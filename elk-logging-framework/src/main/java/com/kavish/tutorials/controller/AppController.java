package com.kavish.tutorials.controller;

import com.kavish.tutorials.service.AppBusiness;
import com.kavish.tutorials.model.FacadeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private AppBusiness business;

    @RequestMapping(value="/v1/hitMyService", method = RequestMethod.GET)
    public FacadeResponse hitService() throws Exception {

        configureProxy();
        return business.transform();
    }

    private void configureProxy() {
        System.setProperty("http.proxyHost", "orrproxy.mphasis.com");
        System.setProperty("http.proxyPort", "8080");

        System.setProperty("https.proxyHost", "orrproxy.mphasis.com");
        System.setProperty("https.proxyPort", "8080");
    }

}