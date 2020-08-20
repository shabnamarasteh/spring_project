package org.j2os.monitor.modules.device.controller;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin")
public class RackController {
    private ServiceInterface datacenterService;
    private ServiceInterface rackService;

    @Autowired
    public RackController(
            @Qualifier("datacenterService") ServiceInterface datacenterService,
            @Qualifier("rackService") ServiceInterface rackService) {
        this.datacenterService = datacenterService;
        this.rackService = rackService;
    }

    @RequestMapping(value = "/rack/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("datacenters", this.datacenterService.findAll());
        return "admin/device/rackCreate";
    }

    @RequestMapping(value = {"/rack/all.do", "/rack/index.do"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("racks", this.rackService.findAll());
        return "admin/device/rackList";
    }

    @RequestMapping(value = "/rack/save.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("rack") Rack rack, Model model) {
        Datacenter datacenter = (Datacenter) this.datacenterService.findById(rack.getDatacenterId().getId());
        rack.setDatacenterId(datacenter);
        this.rackService.add(rack);
        return "redirect:/admin/rack/all.do";
    }

    @RequestMapping(value = "/rack/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        Rack rack = (Rack) this.rackService.findById(id);
        this.rackService.delete(rack);
        return "redirect:/admin/rack/all.do";
    }

    @RequestMapping(value = "/rack/{id}/edit.do", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("datacenters" , this.datacenterService.findAll());
        model.addAttribute("rack", this.rackService.findById(id));
        model.addAttribute("id", id);
        return "admin/device/rackEdit";
    }

    @RequestMapping(value = "/rack/{id}/edit.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("rack") Rack rack,@PathVariable("id") long id,Model model) {
        rack.setId(id);
        Datacenter datacenter = (Datacenter) this.datacenterService.findById(rack.getDatacenterId().getId());
        rack.setDatacenterId(datacenter);
        try {
            this.datacenterService.update(datacenter);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/rack/all.do";
    }

}
