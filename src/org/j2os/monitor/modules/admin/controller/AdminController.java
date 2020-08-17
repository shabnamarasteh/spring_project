package org.j2os.monitor.modules.admin.controller;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("items", adminServiceInterface.findAll());
        return "/admin/admin/list";
    }

    @RequestMapping(value = "/admin/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        List<Role> roles = roleServiceInterface.findAll();
        model.addAttribute("roles", roles);
        return "/admin/admin/create";
    }

    @RequestMapping(value = "/admin/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("admin") Admin admin) {
        if (admin.getRoleId().getId() != 0) {
            Role role = (Role) roleServiceInterface.findById(admin.getRoleId().getId());
            admin.setRoleId(role);
        }
        adminServiceInterface.add(admin);
        return "redirect:/admin/index.do";
    }

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
