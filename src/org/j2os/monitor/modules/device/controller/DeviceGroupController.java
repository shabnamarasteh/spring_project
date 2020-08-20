package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/deviceGroup")
public class DeviceGroupController {
    private ServiceInterface deviceGroupService;

    @Autowired
    public DeviceGroupController(@Qualifier("deviceGroupService") ServiceInterface deviceGroupService) {
        this.deviceGroupService = deviceGroupService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", deviceGroupService.findAll());
        return "/admin/device/deviceGroupList";
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        return "/admin/device/deviceGroupCreate";
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("deviceGroup") DeviceGroup deviceGroup) {
        deviceGroupService.add(deviceGroup);
        return "redirect:/admin/deviceGroup/index.do";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable long id) {
        DeviceGroup deviceGroup = (DeviceGroup) this.deviceGroupService.findById(id);
        return "admin/admin/create";
    }


    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete_dg(@RequestParam("deviceGroupId") long id) {
        DeviceGroup deviceGroup = (DeviceGroup) this.deviceGroupService.findById(id);
        if (deviceGroup != null) {
            this.deviceGroupService.delete(deviceGroup);
        }
        return "redirect:/admin/deviceGroup/index.do";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        DeviceGroup deviceGroup = (DeviceGroup) this.deviceGroupService.findById(id);
        this.deviceGroupService.delete(deviceGroup);
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
