package org.microservice.clientgreeting;


import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Greeting DTO - se uso para interactuar con {@link ClientGreetingService}.
 * 
 * @author Josue Chilon
 */
@JsonRootName("greeting")
public class Greeting {

  
    protected String content;
    
    /**
	 * Default constructor 
	 */
	protected Greeting() {
		this.content = "Hello!";
	}

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
