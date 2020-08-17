package org.j2os.monitor.modules.device.controller;


import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class DeviceController {
    private ServiceInterface serviceInterface;

    @Autowired
    public DeviceController(
            @Qualifier("deviceService") ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @RequestMapping(value = "/device/create.do", method = RequestMethod.GET)
    public String create() {
        return "admin/admin/create";
    }

    @RequestMapping(value = "/device/all.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("devices", serviceInterface.findAll());
        return "admin/device/deviceList";
    }

}
