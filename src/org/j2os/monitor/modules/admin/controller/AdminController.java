package org.j2os.monitor.modules.admin.controller;

import org.j2os.monitor.modules.admin.model.service.AdminService;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ServiceInterface serviceInterface;

    @Autowired
    public AdminController(@Qualifier("adminService") ServiceInterface serviceInterface)
    {
        this.serviceInterface = serviceInterface;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", serviceInterface.findAll());
        return "/admin/admin/list";
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
