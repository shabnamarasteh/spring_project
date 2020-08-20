package org.j2os.monitor.modules.owner.controller;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795

@Controller
@RequestMapping("/owner")
public class OwnerDeviceController {
    private ServiceInterface ownerDeviceService;

    @Autowired
<<<<<<< HEAD
    public OwnerDeviceController(@Qualifier("ownerDeviceService") ServiceInterface ownerDeviceService) {
=======
    public OwnerDeviceController(@Qualifier("ownerDeviceService") ServiceInterface ownerDeviceService)
    {
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
        this.ownerDeviceService = ownerDeviceService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", ownerDeviceService.findAll());
        return "/admin/owner/ownerList";
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
<<<<<<< HEAD
    public String create(Model model) {
=======
    public String create(Model model)
    {
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
        return "/admin/owner/ownerCreate";
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("owner") OwnerDevice owner) {
<<<<<<< HEAD
=======
        System.out.println("-------145454-----");
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
        ownerDeviceService.add(owner);
        return "redirect:/owner/index.do";
    }
//
//    @RequestMapping(value = "/edit/{id}")
//    public String editForm(@PathVariable long id) {
//        Admin admin = (Admin) this.serviceInterface.findById(id);
//        return "admin/admin/create";
//    }
<<<<<<< HEAD

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("ownerId") long id) {
        OwnerDevice admin = (OwnerDevice) this.ownerDeviceService.findById(id);
        if (admin != null) {
            this.ownerDeviceService.delete(admin);
        }
        return "redirect:/owner/index.do";
    }
=======
//
//    //    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @RequestMapping(value = "/delete/{id}")
//    public String delete(@PathVariable long id) {
//        Admin admin = (Admin) this.serviceInterface.findById(id);
//        this.serviceInterface.delete(admin);
//        return "redirect:admin/admin/";
//    }
//
>>>>>>> 5a15f5399c81dab47f8fdd2bd2ff250c0d9ec795
//    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
//    public String findOne(@PathVariable long id) {
//        return "admin/admin/create";
//    }
//
//    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
//    public String findAll() {
//        return "admin/admin/list";
//    }
}
