package com.example.shop.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController("/")
public class BaseController {
    @GetMapping
    public ModelAndView goToBasePage(){
        return new ModelAndView("base");
    }
}
