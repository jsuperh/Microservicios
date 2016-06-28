package org.microservice.clientgreeting;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Client controller, microservice via
 * {@link ClientGreetingService}.
 * 
 * @author Josue Chilon
 */
@Controller
public class ClientGreetingController {

	@Autowired
	protected ClientGreetingService helloWorldService;

	protected Logger logger = Logger.getLogger(ClientGreetingController.class
			.getName());

	//constructor
	public ClientGreetingController(ClientGreetingService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping("/greeting")
	public String goHome() {
		return "index";
	}
	
	@RequestMapping("/greeting/{name}")
	public String greeting(Model model, @PathVariable("name") String name) {
	
		logger.info("Servicio Hola Mundo greeting() invoco: " + name);

		Greeting greeting = helloWorldService.greeting(name);
		
		logger.info("Servicio Hola Mundo - greeting() encontro: " + greeting.getContent());
	
		model.addAttribute("greeting", greeting.getContent());
	
		return "greeting";
		
	}
	
}
