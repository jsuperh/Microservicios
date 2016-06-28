package org.microservice.clientgreeting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Usando el Discovery Server (Eureka) para que este buscando el microservice.
 * Puede ser implementado para conetarse como cliente cloud spring
 * @author Josue Chilon
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) 
public class ClientGreetingServer {

	
	public static final String SERVICE_URL = "http://GREETING-SERVICE";

	
	public static void main(String[] args) {
		SpringApplication.run(ClientGreetingServer.class, args);
	}
	
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ClientGreetingService helloWorldService() {
		return new ClientGreetingService(SERVICE_URL);
	}

	@Bean
	public ClientGreetingController helloWorldController() {
		return new ClientGreetingController(helloWorldService());
	}

	@Bean
	public ClientGreetingHomeController homeController() {
		return new ClientGreetingHomeController();
	}
}
