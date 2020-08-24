package com.rtzan.camel.k8s.first.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ServerApplication {

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
