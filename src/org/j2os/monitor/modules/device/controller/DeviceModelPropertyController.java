package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.entity.DeviceModelProperty;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/deviceModelProperty")
public class DeviceModelPropertyController {
    private ServiceInterface devicePropertyService;
    private ServiceInterface deviceModelService;

    @Autowired
    public DeviceModelPropertyController(@Qualifier("deviceModelPropertyService") ServiceInterface devicePropertyService,
                                         @Qualifier("deviceModelService") ServiceInterface deviceModelService) {
        this.devicePropertyService = devicePropertyService;
        this.deviceModelService = deviceModelService;
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items", devicePropertyService.findAll());
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
        devicePropertyService.add(deviceProperty);
        return "redirect:/admin/deviceModelProperty/index.do";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable long id) {
        DeviceModelProperty deviceProperty = (DeviceModelProperty) this.devicePropertyService.findById(id);
        return "admin/deviceModelProperty/deviceModelPropertyCreate";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable long id) {
        DeviceModelProperty deviceProperty = (DeviceModelProperty) this.devicePropertyService.findById(id);
        this.devicePropertyService.delete(deviceProperty);
        return "redirect:admin/deviceModelProperty";
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


