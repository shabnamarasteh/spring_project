package org.j2os.monitor.modules.device.controller;
import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin")
public class DatacenterController {
    private ServiceInterface datacenterService;
    private ServiceInterface cityService;

    @Autowired
    public DatacenterController(@Qualifier("datacenterService") ServiceInterface datacenterService,
                                @Qualifier("cityService") ServiceInterface cityService) {
        this.datacenterService = datacenterService;
        this.cityService = cityService;
    }

    @RequestMapping(value = "/datacenter/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("cities" , this.cityService.findAll());
        return "admin/device/datacenterCreate";
    }

    @RequestMapping(value = "/datacenter/all.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("datacenters", this.datacenterService.findAll());
        return "admin/device/datacenterList";
    }

    @RequestMapping(value = "/datacenter/save.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("datacenter") Datacenter datacenter, Model model) {
        City city = (City) this.cityService.findById(datacenter.getCityId().getId());
        datacenter.setCityId(city);
        this.datacenterService.add(datacenter);
        return "redirect:/admin/datacenter/all.do";
    }

    @RequestMapping(value = "/datacenter/{id}/edit.do", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("cities" , this.cityService.findAll());
        model.addAttribute("datacenter", this.datacenterService.findById(id));
        model.addAttribute("id", id);
        return "admin/device/datacenterCreate";
    }

    @RequestMapping(value = "/datacenter/{id}/edit.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("datacenter") Datacenter datacenter,@PathVariable("id") long id,Model model) {
        datacenter.setId(id);
        City city = (City) this.cityService.findById(datacenter.getCityId().getId());
        datacenter.setCityId(city);
        try {
            this.datacenterService.update(datacenter);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/datacenter/all.do";
    }
    @RequestMapping(value = "/datacenter/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        Datacenter datacenter = (Datacenter) this.datacenterService.findById(id);
        this.datacenterService.delete(datacenter);
        return "redirect:/admin/datacenter/all.do";
    }
}
