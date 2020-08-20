package org.j2os.monitor.modules.owner.controller;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/owner")
public class OwnerDeviceController {
    private ServiceInterface ownerDeviceService;

    @Autowired
    public OwnerDeviceController(@Qualifier("ownerDeviceService") ServiceInterface ownerDeviceService) {
        this.ownerDeviceService = ownerDeviceService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", ownerDeviceService.findAll());
        return "/admin/owner/ownerList";
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        return "/admin/owner/ownerCreate";
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("owner") OwnerDevice owner) {
        ownerDeviceService.add(owner);
        return "redirect:/owner/index.do";
    }

    @RequestMapping(value = "/{id}/edit.do",method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model) {
        OwnerDevice admin = (OwnerDevice) this.ownerDeviceService.findById(id);
        model.addAttribute("owner",admin);
        return "admin/owner/ownerEdit";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("owner") OwnerDevice owner) {
        try {
            ownerDeviceService.update(owner);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "redirect:/owner/index.do";
    }


    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("ownerId") long id) {
        OwnerDevice admin = (OwnerDevice) this.ownerDeviceService.findById(id);
        if (admin != null) {
            this.ownerDeviceService.delete(admin);
        }
        return "redirect:/owner/index.do";
    }

}
