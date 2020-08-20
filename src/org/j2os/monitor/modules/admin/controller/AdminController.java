package org.j2os.monitor.modules.admin.controller;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;
=======
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ServiceInterface adminServiceInterface;
    private ServiceInterface roleServiceInterface;
<<<<<<< HEAD

    @Autowired
    public AdminController(@Qualifier("adminService") ServiceInterface adminServiceInterface,
                           @Qualifier("roleService") ServiceInterface roleServiceInterface) {
        this.adminServiceInterface = adminServiceInterface;
        this.roleServiceInterface = roleServiceInterface;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", this.adminServiceInterface.findAll());
=======

    @Autowired
    public AdminController(@Qualifier("adminService") ServiceInterface adminServiceInterface,
                           @Qualifier("roleService") ServiceInterface roleServiceInterface) {
        this.adminServiceInterface = adminServiceInterface;
        this.roleServiceInterface = roleServiceInterface;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", adminServiceInterface.findAll());
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
        return "/admin/admin/list";
    }

    @RequestMapping(value = "/admin/create.do", method = RequestMethod.GET)
    public String create(Model model) {
<<<<<<< HEAD
        List<Role> roles = this.roleServiceInterface.findAll();
=======
        List<Role> roles = roleServiceInterface.findAll();
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
        model.addAttribute("roles", roles);
        return "/admin/admin/create";
    }

    @RequestMapping(value = "/admin/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("admin") Admin admin) {
        if (admin.getRoleId().getId() != 0) {
<<<<<<< HEAD
            Role role = (Role) this.roleServiceInterface.findById(admin.getRoleId().getId());
=======
            Role role = (Role) roleServiceInterface.findById(admin.getRoleId().getId());
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
            admin.setRoleId(role);
        }
        adminServiceInterface.add(admin);
        return "redirect:/admin/index.do";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/edit.do",method = RequestMethod.POST)
    public String editForm(@RequestParam("adminId") long id,Model model) {
        Admin admin = (Admin) this.adminServiceInterface.findById(id);
        model.addAttribute("admin",admin);
        List<Role> roles = this.roleServiceInterface.findAll();
        model.addAttribute("roles", roles);
        return "admin/admin/create";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("adminId") long id) {
        Admin admin = (Admin) this.adminServiceInterface.findById(id);
        if(admin != null){
            this.adminServiceInterface.delete(admin);
        }
        return "redirect:/admin/index.do";
=======
    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable long id) {
        Admin admin = (Admin) this.adminServiceInterface.findById(id);
        return "admin/admin/create";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        Admin admin = (Admin) this.adminServiceInterface.findById(id);
        this.adminServiceInterface.delete(admin);
        return "redirect:admin/admin/";
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
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
