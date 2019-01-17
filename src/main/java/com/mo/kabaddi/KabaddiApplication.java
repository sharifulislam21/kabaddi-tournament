package com.mo.kabaddi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(value = { @ComponentScan("org.mo.kabaddi.*") })
public class KabaddiApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(KabaddiApplication.class, args);
	}

}

