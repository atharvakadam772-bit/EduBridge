package com.EduBridge.portfolioarchitect.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Portfolio Architect Backend is running successfully!";
    }
}