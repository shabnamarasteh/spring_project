package org.j2os.monitor.modules.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index() {

//        String greet =" Hello !!!" + name + " How are You?";
//
//        model.addAttribute("greet", greet);
        return "admin/index";
    }

    @RequestMapping(value = "/admin/create.do", method = RequestMethod.GET)
    public String create() {
        return "admin/admin/create";
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.POST)
    public String save() {
        return "redirect:admin/admin/";
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable long id) {
        return "redirect:admin/admin/";
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable long id) {
        return "admin/admin/create";
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public String findAll() {
        return "admin/admin/list";
    }
}
