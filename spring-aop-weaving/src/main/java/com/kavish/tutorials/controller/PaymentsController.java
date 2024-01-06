package com.kavish.tutorials.controller;

import com.kavish.tutorials.aspect.LogResponseTime;
import com.kavish.tutorials.aspect.LogResponseTimeAspect;
import com.kavish.tutorials.service.PaymentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentsController {
    private static final Logger log = LoggerFactory.getLogger(PaymentsController.class);
    @Autowired
    PaymentsService paymentsService;
    @Autowired
    LogResponseTimeAspect logResponseTimeAspect;
    private ResponseEntity<String> response;

    public PaymentsController(PaymentsService paymentsService, LogResponseTimeAspect logResponseTimeAspect) {
        this.paymentsService = paymentsService;
        this.logResponseTimeAspect = logResponseTimeAspect;
    }

    @LogResponseTime(apiName = "getCards")
    @GetMapping("/cards")
    public ResponseEntity<String> getCards() throws Exception {
        log.info("Entered getCards API");
        try{
            response = paymentsService.getCards();
        }catch (Exception ex){
            throw new RuntimeException("Error Occurred while Fetching");
        }
        return response;
    }
    @LogResponseTime(apiName = "addCards")
    @PostMapping("/cards/add")
    public ResponseEntity<String> addCards(@RequestBody String payload) throws Exception {
        log.info("Entered addCards API");
        try{
            response = paymentsService.addCards(payload);
        }catch (Exception ex){
            throw new RuntimeException("Error Occurred while Creation");
        }
        return response;
    }
}
