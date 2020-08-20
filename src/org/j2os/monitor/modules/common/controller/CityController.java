package org.j2os.monitor.modules.common.controller;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.modules.common.model.service.CityService;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin")
public class CityController {
    private ServiceInterface cityService;
    private ServiceInterface stateService;

    @Autowired
    public CityController(@Qualifier("cityService") ServiceInterface cityService
                          ,@Qualifier("stateService") ServiceInterface stateService) {
        this.cityService = cityService;
        this.stateService = stateService;
    }

    @RequestMapping(value = "/city/create.do", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("states", this.stateService.findAll());
        return "admin/config/cityCreate";
    }

    @RequestMapping(value = "/city/all.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("cities", this.cityService.findAll());
        return "admin/config/cityList";
    }

    @RequestMapping(value = "/city/{id}/edit.do", method = RequestMethod.GET)
    public String edit( @PathVariable("id") long id,Model model) {
        model.addAttribute("city", this.cityService.findById(id));
        model.addAttribute("states", this.stateService.findAll());
        model.addAttribute("id", id);
        return "admin/config/cityEdit";
    }

    @RequestMapping(value = "/city/{id}/edit.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("city") City city,@PathVariable("id") long id,Model model) {
        city.setId(id);
        State state = (State) this.stateService.findById(city.getStateId().getId());
        city.setStateId(state);
        try {
            this.cityService.update(city);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/city/all.do";
    }
    @RequestMapping(value = "/city/save.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("city") City city, Model model) {
        State state = (State)this.stateService.findById(city.getStateId().getId());
        city.setStateId(state);
        this.cityService.add(city);
        return "redirect:/admin/city/all.do";
    }

    @RequestMapping(value = "/city/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        City city = (City) this.cityService.findById(id);
        this.cityService.delete(city);
        return "redirect:/admin/city/all.do";
    }
}
