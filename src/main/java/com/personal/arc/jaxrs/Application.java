package com.personal.arc.jaxrs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.personal.arc.jaxrs")
public class Application implements CommandLineRunner {

    private static Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) throws Exception {
        log.info("..................Enter main method..................");
        SpringApplication.run(Application.class, args);
        log.info("..................Main method complete..................");
    }
    @Override
    public void run(String... args) {
        log.info("..................Server start..................");
    }
}