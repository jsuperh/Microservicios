package org.microservice.clientgreeting;


import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author Josue Chilon
 */
@Service
public class ClientGreetingService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(ClientGreetingService.class
			.getName());

	public ClientGreetingService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
	}
	
	@PostConstruct
	public void demoOnly() {

		logger.warning("RestFull request fabricado es "
				+ restTemplate.getRequestFactory());
	}

	public Greeting greeting (String name) {	

		logger.info("greeting() invocado: para " + name);		
		Greeting greeting =  restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);	
		return greeting;
		
	}

	
}
