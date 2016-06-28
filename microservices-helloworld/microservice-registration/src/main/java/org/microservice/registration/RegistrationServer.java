package org.microservice.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Se necesita correr un Eureka registration server.
 * 
 * @author Josue Chilon
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

	/**
	 *  
	 * @param args
	 *            Program arguments - ignored. XX
	 */
	public static void main(String[] args) {

		SpringApplication.run(RegistrationServer.class, args);
	
	}
}
