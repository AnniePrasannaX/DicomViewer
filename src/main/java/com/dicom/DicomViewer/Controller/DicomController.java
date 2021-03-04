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
import java.util.Objects;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dicom.DicomViewer.domain.User;
import com.dicom.DicomViewer.response.LastLogintimeResponse;
import com.dicom.DicomViewer.response.LoginResponse;
import com.dicom.DicomViewer.service.UserService;
import com.dicom.DicomViewer.repository.UserRepository;
import com.dicom.DicomViewer.response.PasswordResponse;
import com.dicom.DicomViewer.response.UploadResponse;

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
	
	/**
	 * Method login handles the HTTP POST requests matched with login URI
	 * @param user
	 * @return LoginResponse
	 */
	@PostMapping("/login")
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
    @PostMapping("/settings")
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
	@PostMapping(value="/upload")
    public UploadResponse singleFileUpload(@RequestParam("file") MultipartFile file){
		
      if (file.isEmpty()) {  //returns fail message if file uploaded is empty
          
          return new UploadResponse("Failed");
      }

      try {

          // Get the file and save it somewhere
          byte[] bytes = file.getBytes();
          Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
          Files.write(path, bytes);
          } catch (IOException e) {
          e.printStackTrace();
      }

   return new UploadResponse("Success");   
   }
	
}    
	



