package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
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


import java.util.List;

@Controller
@RequestMapping("/admin/deviceModel")
public class DeviceModelController{
    private ServiceInterface deviceModelService;

    @Autowired
    public DeviceModelController(@Qualifier("deviceModelService") ServiceInterface deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", deviceModelService.findAll());
        return "/admin/device/deviceModelList";
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        return "/admin/device/deviceModelCreate";
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("deviceModel") DeviceModel deviceModel) {
        deviceModelService.add(deviceModel);
        return "redirect:/admin/deviceModel/index.do";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable long id) {
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(id);
        return "admin/admin/create";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete_dm(@RequestParam("deviceModelId") long id) {
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(id);
        if (deviceModel != null) {
            this.deviceModelService.delete(deviceModel);
        }
        return "redirect:/admin/deviceModel/index.do";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(id);
        this.deviceModelService.delete(deviceModel);
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

