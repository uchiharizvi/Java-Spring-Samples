package com.kavish.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
public class AuthorizationServerApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(AuthorizationServerApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
        //SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @GetMapping("/api")
    String api() {
        return "Made it to protected api on resource server!";
    }
}
