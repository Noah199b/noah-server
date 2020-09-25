package com.noah1996.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class IndexController {

    @GetMapping("")
    public String index(){
        return "welcome to admin Index!";
    }
}
