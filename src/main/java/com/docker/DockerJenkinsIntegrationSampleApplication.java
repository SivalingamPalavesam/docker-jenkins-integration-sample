package com.docker;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class DockerJenkinsIntegrationSampleApplication {

	@Bean(name="displayOrders")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) 
	{
		
		SpringApplication.run(DockerJenkinsIntegrationSampleApplication.class, args);
	}

}
