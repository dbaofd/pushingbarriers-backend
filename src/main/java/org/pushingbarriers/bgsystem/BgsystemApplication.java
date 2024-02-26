package org.pushingbarriers.bgsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * When deploying the project to tomcat, the main class need to extends SpringBootServletInitializer
 * SpringApplicationBuilder will be needed
 * Otherwise, remove 'extends' and SpringApplicationBuilder
 */
@SpringBootApplication
@EnableScheduling
public class BgsystemApplication extends SpringBootServletInitializer{//extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(BgsystemApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BgsystemApplication.class);
    }

}

