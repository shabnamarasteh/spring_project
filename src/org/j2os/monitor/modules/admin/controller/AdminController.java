package org.j2os.monitor.modules.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    @RequestMapping(value = "/greet.do",method= RequestMethod.GET)
    public String greet(){

//        String greet =" Hello !!!" + name + " How are You?";
//
//        model.addAttribute("greet", greet);

        System.out.println("greet");
        return "admin/index";

    }
}
