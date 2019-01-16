package com.okta.developer.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan({"com.okta."})
@EntityScan("com.okta.")
@EnableJpaRepositories("com.okta.")
public class DemoApplication {

	public static void main(String[] args)
	
	{
		
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	
	@Bean
	ApplicationRunner init(CarRepository repository)
	{
		
		return args -> {
			
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(
                    		name -> {
                    			
                    			Car car = new Car();
                    			car.setName(name);
                    			repository.save(car);
                    		});
			repository.findAll().forEach(System.out::println);
			
			
		};
		
	}
	
}
