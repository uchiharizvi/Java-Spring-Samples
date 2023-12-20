package com.kavish.tutorials;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Sso//The @EnableOAuth2Sso annotation is necessary to hook into the spring-security-oauth2 library in this class.
@RestController
@SpringBootApplication
public class DemoApplication {
    @Value("#{ @environment['security.oauth2.resource.server'] }")
    private String resourceServerUrl;
    private OAuth2ProtectedResourceDetails resource;

    public DemoApplication(OAuth2ProtectedResourceDetails resource) {
        this.resource = resource;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * The root mapping method - @GetMapping("/") - takes an OAuth2Authentication object as its parameter.
     * The getName() displays the full name. The Authorization Code Flow will be kicked off automatically
     * by Spring Security when you access this path.
     **/
    @GetMapping("/")
    String home(OAuth2Authentication authentication) {
        return "Hello " + authentication.getName();
    }

    @GetMapping("/api")
    String api(OAuth2Authentication authentication) {
        return tokenRelayTemplate(authentication)
                .getForObject(resourceServerUrl + "/api", String.class);
    }

    private OAuth2RestTemplate tokenRelayTemplate(OAuth2Authentication authentication) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2ClientContext context = new DefaultOAuth2ClientContext(new DefaultOAuth2AccessToken(details.getTokenValue()));
        return new OAuth2RestTemplate(resource, context);
    }
}
