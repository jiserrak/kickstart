package com.author.kickstart;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class KickstartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =  SpringApplication.run(KickstartApplication.class, args);
		String applicationName = applicationContext.getApplicationName();
		System.out.println("Application Name: " + applicationName);
		KickstartApplication kickstartApplication =
				(KickstartApplication)
				applicationContext.getBean("kickstartApplication");
		Map<String, Object> classWithAnnotations =
				applicationContext.getBeansWithAnnotation(SpringBootApplication.class);
		ConfigurableEnvironment environment =
				applicationContext.getEnvironment();
		System.out.println("HOLA, " + Arrays.asList(environment.getDefaultProfiles()));
		
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext();
		applicationContext2.scan("com.author.kickstart");
		System.out.println(applicationContext2.getEnvironment().getDefaultProfiles()[0]);
		
	}

}
