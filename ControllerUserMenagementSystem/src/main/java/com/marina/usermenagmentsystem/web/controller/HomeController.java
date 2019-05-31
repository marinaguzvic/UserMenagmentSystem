/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marina.usermenagmentsystem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MARINA
 */
@Controller
public class HomeController {
    
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
