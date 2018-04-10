package com.dd.demo.controller;

import com.dd.demo.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @Autowired
    ProjectConfig projectConfig;

    @RequestMapping(value = "/index")
    public String Root(){
        return "index";
    }
}
