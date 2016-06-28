package org.microservice.greeting;

import java.util.logging.Logger;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * A RESTFul controller .
 * 
 * @author Josue Chilon
 */
@RestController
public class GreetingController {
	
	protected Logger logger = Logger.getLogger(GreetingController.class
			.getName());
	
	private static final String template = "Hola soy, %s!";
	
	/**
	 *  
	 * @param name
	 * @return a greeting "Hola soy" + name	
	 */	
	@RequestMapping("/greeting/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return new Greeting(String.format(template, name));		
    }

}
