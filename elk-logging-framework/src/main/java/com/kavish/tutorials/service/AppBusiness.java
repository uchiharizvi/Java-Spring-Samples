package com.kavish.tutorials.service;

import com.kavish.tutorials.model.FacadeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppBusiness {

    @Autowired
    private AppService service;

    public FacadeResponse transform() throws Exception {

        return service.getService();
    }
}
