package com.webservices.soap;

import com.webservices.GetCountryRequest;
import com.webservices.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Spain";//Default Name
			if(args.length>0){
				name = args[0];
			}
			GetCountryRequest request = new GetCountryRequest();
			request.setName(name);
			GetCountryResponse response =(GetCountryResponse) soapConnector.callWebService("http://localhost:9000/ws/countries", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Country : "+response.getCountry().getName());
		};
	}
}
