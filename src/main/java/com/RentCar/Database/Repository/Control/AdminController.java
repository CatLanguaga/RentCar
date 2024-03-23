package com.RentCar.Database.Repository.Control;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping
    public String helloAdmin(){
        
        return "Hello admin";
    }
    
}
