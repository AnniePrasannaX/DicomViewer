/**
 * Class DicomController
 * performs all the logic and
 * provides web services
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 * 
 */


/* Package statement*/
package com.dicom.DicomViewer.Controller;


/**
 * import statements 
 * for files,instant time
 * and controller mappings
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dicom.DicomViewer.domain.User;
import com.dicom.DicomViewer.domain.User1;
import com.dicom.DicomViewer.repository.UserRepository;
import com.dicom.DicomViewer.response.LastLogintimeResponse;
import com.dicom.DicomViewer.response.LoginResponse;
import com.dicom.DicomViewer.response.PasswordResponse;
import com.dicom.DicomViewer.response.UploadResponse;
import com.dicom.DicomViewer.service.User1Service;
//import com.dicom.DicomViewer.service.User2Service;
import com.dicom.DicomViewer.service.UserService;
@CrossOrigin(origins="*" , allowedHeaders="*")
/**
 * Marks a class as Spring MVC,
 * creates a Map of the model object and find a view
 * 
 *
 */
@Controller

/**
 *binds a method return value
 *to the web response body 
 */
@ResponseBody
/**
 * @class DicomController
 *
 */
public class DicomController {
	
	/**
	 * Automatically inject dependencies of the specified type into the current bean
	 */
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository ur;
	@Autowired
	private User1Service user1Service;
	//@Autowired
	//private User2Service user2Service;
	
	/**
	 * Method login handles the HTTP POST requests matched with login URI
	 * @param user
	 * @return LoginResponse
	 */
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public LoginResponse login(@ModelAttribute("user")User user) {
		
		User us=userService.login(user.getUsername(), user.getPassword());//get the admin credentials from database
		if(Objects.nonNull(us))                                           //compares the entered and actual admin credentials
			return new LoginResponse("200","Login Successful");
		else
			return new LoginResponse("401","Invalid Credentials");
	}
	
	
	
	/**
	 * Method time handles the HTTP POST requests matched with lastlogintime URI
	 * @return LastLogintimeResponse
	 */
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/lastlogintime")
    public LastLogintimeResponse time() {
    	Instant instant = Instant.now();
    	long timeStampMillis = instant.toEpochMilli();  //get the current epoch timestamp
    	return new LastLogintimeResponse(timeStampMillis);
    	
    }
	
	/**
	 * Method changePass handles the HTTP POST requests matched with settings URI
	 * @param oldPass
	 * @param newPass
	 * @param user
	 * @return PasswordResponse
	 */
	@CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value="/settings",method=RequestMethod.POST)
	public PasswordResponse changePass(@RequestParam("oldPass") String oldPass , @RequestParam("newPass") String newPass ,@ModelAttribute("user")User user) {
		 
		
		User currentUser=this.ur.getUserByUserName("admin");      //get the admin username
		
		if (oldPass.equals(currentUser.getPassword())){           //compares the old and new password
			
			int us=this.ur.setUserByUserName(newPass, "admin");   //replaces the existing password with new one
			return new PasswordResponse("Password changed Successfully");
		}
		else
			return new PasswordResponse("Password change Failed");
		
	}

	
	/* Folder to store uploaded file*/
    
	private static String UPLOADED_FOLDER = "D://temp//";
	
	/**
	 * Method singleFileUpload handles the HTTP POST requests matched with upload URI
	 * @param file
	 * @return UploadResponse
	 */
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/upload")
    public Iterable<User1> singleFileUpload(@RequestParam("file") MultipartFile file,Model model){
		
      

      try {

          // Get the file and save it somewhere
          byte[] bytes = file.getBytes();
          Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
          Files.write(path, bytes);
          } catch (IOException e) {
          e.printStackTrace();
      }
      return user1Service.list();
     
   }
	
    
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/All") // Map all the patients details
	public List<User1> getAllPatients() {
		return user1Service.getAllPatients();
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/search") // Map the patient details based on search by id or name
	public List<User1> viewHomePage(Model model, @Param("keyword") String keyword) {
		List<User1> listPatients = user1Service.getSearch(keyword);
		model.addAttribute("listPatients", listPatients);
		model.addAttribute("keyword", keyword);
		return listPatients;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/count") // Map the total number of files
	
	public long countEntities() {
		long count = user1Service.getCountOfEntities();
		return count;
	}
	
}    
	



