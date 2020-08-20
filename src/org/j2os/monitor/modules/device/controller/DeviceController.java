package org.j2os.monitor.modules.device.controller;


import org.j2os.monitor.modules.device.model.entity.Device;
import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin")
public class DeviceController {
    private ServiceInterface deviceService;
    private ServiceInterface rackService;
    private ServiceInterface deviceModelService;

    @Autowired
    public DeviceController(
            @Qualifier("deviceService") ServiceInterface deviceService,
            @Qualifier("rackService") ServiceInterface rackService,
            @Qualifier("deviceModelService") ServiceInterface deviceModelService
    )
    {
        this.deviceService = deviceService;
        this.rackService = rackService;
        this.deviceModelService = deviceModelService;
    }

    @RequestMapping(value = "/device/create.do", method = RequestMethod.GET)
    public String create() {
        return "admin/device/deviceCreate";
    }

    @RequestMapping(value = {"/device/all.do", "/device/index.do"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("devices", this.deviceService.findAll());
        return "admin/device/deviceList";
    }

    @RequestMapping(value = "/device/save.do", method = RequestMethod.POST)
    public String submit( @ModelAttribute("device") Device device, Model model) {
        Rack rack = (Rack) this.rackService.findById(device.getRackId().getId());
//        OwnerDevice ownerDevice = (OwnerDevice) this.ownerDeviceService.findById(device.getOwnerDevice().getOwnerId());
        DeviceModel deviceModel = (DeviceModel) this.deviceModelService.findById(device.getDeviceModel().getId());
        device.setRackId(rack);
//        device.setOwnerDevice(ownerDevice);
        device.setDeviceModel(deviceModel);
        this.deviceService.add(device);
        return "redirect:/admin/device/all.do";
    }

    @RequestMapping(value = "/device/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        Device device = (Device) this.deviceService.findById(id);
        this.deviceService.delete(device);
        return "redirect:/admin/device/all.do";
    }

    @RequestMapping(value = "/device/edit.do/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("racks" , this.rackService.findAll());
        model.addAttribute("device", this.deviceService.findById(id));
        model.addAttribute("id", id);
        return "admin/device/DeviceCreate";
    }

    @RequestMapping(value = "/rack/edit.do/{id}", method = RequestMethod.PUT)
    public String update(@ModelAttribute("device") Device device,@PathVariable("id") long id,Model model) {
        device.setId(id);
        Rack rack = (Rack) this.rackService.findById(device.getRackId().getId());
        device.setRackId(rack);
        try {
            this.rackService.update(device);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/device/all.do";
    }
}
