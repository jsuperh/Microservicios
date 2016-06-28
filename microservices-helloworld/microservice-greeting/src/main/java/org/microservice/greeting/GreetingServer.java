package org.microservice.greeting;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * Run as a micro-service, registering with the Discovery Server (Eureka)
 * 
 * @author Josue Chilon
 */

@EnableAutoConfiguration // Spring Boot application
@EnableDiscoveryClient //discovery-server service usando la aplicacion nombre 
@SpringBootApplication
public class GreetingServer {
	protected Logger logger = Logger.getLogger(GreetingServer.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(GreetingServer.class, args);
	}
}


