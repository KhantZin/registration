package com.kzw.sprintboot;

import java.text.MessageFormat;

import org.flywaydb.core.Flyway;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kzw.sprintboot.annotation.Custom;

@SpringBootApplication
public class RegistrationApplication {
	
	final static Logger logger = LoggerFactory.getLogger(RegistrationApplication.class);
	
	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/demo", "root", "admin").load();
		flyway.migrate();
		
		Reflections ref = new Reflections("com.kzw.sprintboot");
		for (Class<?> cl : ref.getTypesAnnotatedWith(Custom.class)) {
            Custom custom = cl.getAnnotation(Custom.class);
            String message = MessageFormat.format("[name =  \"{0}\", className = \"{1}\"]", custom.name(), cl.getSimpleName());
            logger.info(message);
        }
		
		SpringApplication.run(RegistrationApplication.class, args);
	}
	
	

}
