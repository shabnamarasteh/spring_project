package org.j2os.monitor.modules.admin.controller;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ServiceInterface adminServiceInterface;
    private ServiceInterface roleServiceInterface;

    @Autowired
    public AdminController(@Qualifier("adminService") ServiceInterface adminServiceInterface,
                           @Qualifier("roleService") ServiceInterface roleServiceInterface) {
        this.adminServiceInterface = adminServiceInterface;
        this.roleServiceInterface = roleServiceInterface;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", this.adminServiceInterface.findAll());
        return "/admin/admin/list";
    }

    @RequestMapping(value = "/admin/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        List<Role> roles = this.roleServiceInterface.findAll();
        model.addAttribute("roles", roles);
        return "/admin/admin/create";
    }

    @RequestMapping(value = "/admin/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("admin") Admin admin) {
        if (admin.getRoleId().getId() != 0) {
            Role role = (Role) this.roleServiceInterface.findById(admin.getRoleId().getId());
            admin.setRoleId(role);
        }
        adminServiceInterface.add(admin);
        return "redirect:/admin/index.do";
    }

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
