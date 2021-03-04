/**
 * Class WebContainerConfig to convert 
 * http to https
 * 
 * @author Annie Prasanna X
 * @since 26-02-2021
 */

/*Package statements*/
package com.dicom.DicomViewer.config;

/*import statements*/
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @class WebContainerConfig
 * @Configuration annotation indicates that a class declares one or more @Bean methods 
 * and may be processed by the Spring container
 * to generate bean definitions and service requests for those beans at runtime. 
 *
 */
@Configuration
public class WebContainerConfig {

	/**
	 * Method embeddedServletContainerFactory
	 * @return ServletWebServerFactory
	 */
	@Bean
	public ServletWebServerFactory embeddedServletContainerFactory(){
		TomcatServletWebServerFactory tomcatContainerFactory = new TomcatServletWebServerFactory()
		{
			/**
			 * Method postProcessContext to process based on pattern
			 */
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		tomcatContainerFactory.addAdditionalTomcatConnectors(createSslConnector());
		return tomcatContainerFactory;
		
	}

	/**
	 * Method createSslConnector to redirect from http to https
	 * @return Connector
	 */
	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		 connector.setScheme("http");
		 connector.setPort(8080);
		 connector.setRedirectPort(8443);
		 connector.setSecure(false);
		return connector;
	}
}
