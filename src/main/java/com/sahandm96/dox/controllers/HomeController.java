package com.sahandm96.dox.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @RequestMapping({"/"})
    @ResponseBody
    public String mainPage() {
        return "<h2>index</h2>";
    }
}
