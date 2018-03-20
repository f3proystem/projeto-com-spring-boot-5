package com.f3pro.jpamongo.controller;

import com.f3pro.jpamongo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserRepository userRepository;

   public  UserController(UserRepository userRepository){
       this.userRepository=userRepository;

    }
    @RequestMapping("/user")
    public String getUser(Model model){
       model.addAttribute("userList",this.userRepository.findAll());

       return "user";
    }

}
