package com.maulika.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author maulikabenp
 * Run the application with: http://localhost:8085/student-ws
 *
 */
@SpringBootApplication(scanBasePackages = {"com.maulika"})
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
