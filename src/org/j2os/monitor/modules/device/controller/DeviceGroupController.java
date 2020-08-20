package org.j2os.monitor.modules.device.controller;

import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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


    @RequestMapping(value = "/{id}/edit.do", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model) {
        DeviceGroup deviceGroup = (DeviceGroup) this.deviceGroupService.findById(id);
        model.addAttribute("devGroup", deviceGroup);
        return "/admin/device/deviceGroupEdit";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("deviceGroup") DeviceGroup deviceGroup) {
        try {
            deviceGroupService.update(deviceGroup);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/deviceGroup/index.do";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("deviceGroupId") long id) {
        DeviceGroup deviceGroup = (DeviceGroup) this.deviceGroupService.findById(id);
        if (deviceGroup != null) {
            this.deviceGroupService.delete(deviceGroup);
        }
        return "redirect:/admin/deviceGroup/index.do";
    }
}
