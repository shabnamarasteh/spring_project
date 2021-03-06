package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.entity.DeviceModelProperty;
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

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/admin/deviceModelProperty")
public class DeviceModelPropertyController {

    private ServiceInterface deviceModelPropertyService;
    private ServiceInterface deviceModelService;

    @Autowired
    public DeviceModelPropertyController(@Qualifier("deviceModelPropertyService") ServiceInterface deviceModelPropertyService,
                                         @Qualifier("deviceModelService") ServiceInterface deviceModelService) {
        this.deviceModelPropertyService = deviceModelPropertyService;
        this.deviceModelService = deviceModelService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", deviceModelPropertyService.findAll());
        return "/admin/device/deviceModelPropertyList";
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("deviceModels", this.deviceModelService.findAll());
        return "/admin/device/deviceModelPropertyCreate";
    }

    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String save(@ModelAttribute("deviceProperty") DeviceModelProperty deviceProperty) {
        if (deviceProperty != null && deviceProperty.getDeviceModel().getId() != 0) {
            long deviceId = deviceProperty.getDeviceModel().getId();
            deviceProperty.setDeviceModel((DeviceModel) this.deviceModelService.findById(deviceId));
        }
        deviceModelPropertyService.add(deviceProperty);

        return "redirect:/admin/deviceModelProperty/index.do";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("devicePropertyId") long id) {
        DeviceModelProperty deviceModel = (DeviceModelProperty) this.deviceModelPropertyService.findById(id);
        if (deviceModel != null) {
            this.deviceModelPropertyService.delete(deviceModel);
        }
        return "redirect:/admin/deviceModelProperty/index.do";
    }


    @RequestMapping(value = "/{id}/edit.do", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model) {
        DeviceModelProperty deviceModelProperty = (DeviceModelProperty) this.deviceModelPropertyService.findById(id);
        model.addAttribute("deviceProperty", deviceModelProperty);
        model.addAttribute("deviceModels", this.deviceModelService.findAll());
        return "/admin/device/deviceModelPropertyEdit";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("deviceModelProperty") DeviceModelProperty deviceModelProperty) {
        try {
            if (deviceModelProperty != null && deviceModelProperty.getDeviceModel().getId() != 0) {
                long deviceId = deviceModelProperty.getDeviceModel().getId();
                deviceModelProperty.setDeviceModel((DeviceModel) this.deviceModelService.findById(deviceId));
            }
            deviceModelPropertyService.update(deviceModelProperty);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/deviceModelProperty/index.do";
    }

}


