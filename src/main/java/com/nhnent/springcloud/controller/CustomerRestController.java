package com.nhnent.springcloud.controller;


import com.nhnent.springcloud.domain.ConfigProject;
import com.nhnent.springcloud.domain.Customer;
import com.nhnent.springcloud.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@EnableConfigurationProperties(ConfigProject.class)
@RestController
public class CustomerRestController {

    private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    private final ConfigProject configProject;
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService, ConfigProject configProject) {
        this.customerService = customerService;
        this.configProject = configProject;
    }

    @GetMapping("/customers")
    public Collection<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/name")
    public String getApplicationName() {
        log.info("{}", configProject.getName());
        return configProject.getName();
    }

}
