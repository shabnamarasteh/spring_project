package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
=======

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


>>>>>>> 8d1701c95f4cb6f960dca6edee46aab6f2b86482
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

    @RequestMapping(value = "/{id}/edit.do", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model) {
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(id);
        model.addAttribute("deviceModel", deviceModel);
        return "/admin/device/deviceModelEdit";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("deviceModel") DeviceModel deviceModel) {
        try {
            deviceModelService.update(deviceModel);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
=======
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
>>>>>>> 8d1701c95f4cb6f960dca6edee46aab6f2b86482

        return "redirect:/admin/deviceModel/index.do";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("deviceModelId") long id) {
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(id);
        if (deviceModel != null) {
            this.deviceModelService.delete(deviceModel);
        }
        return "redirect:/admin/deviceModel/index.do";
    }

}

