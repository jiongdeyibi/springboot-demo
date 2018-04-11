package com.dd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String Root(){
        return "index.html";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index.html";
    }

    @RequestMapping(value = "/403")
    public String Addn(){
        return "error.html";
    }

//    @RequestMapping(value = "/login")
//    public String login(){
//        return "login.html";
//    }
    @RequestMapping(value = "/admin/home")
    public String admin(){
        return "/admin/home.html";
    }

}
