package com.codegym.controller;

import com.codegym.model.Accounts;
import com.codegym.model.Role;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class ControllerAccounts {
    @Autowired
    private IAccountService accountService;
    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView("register");
        modelAndView.addObject("Account", new Accounts());
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView createAccount(@ModelAttribute Accounts accounts){
        ModelAndView modelAndView=new ModelAndView("redirect:/login");
        Role role=new Role(2,"ROLE_USER");
        accounts.setRole(role);
        accountService.save(accounts);
        return modelAndView;
    }
}
