package org.microservice.clientgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controlador
 * 
 * @author Josue Chilon
 */
@Controller
public class ClientGreetingHomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
