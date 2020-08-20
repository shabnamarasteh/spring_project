package org.j2os.monitor.modules.common.controller;

import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin")
public class StateController {
    private ServiceInterface stateService;

    @Autowired
    public StateController(@Qualifier("stateService") ServiceInterface stateService) {
        this.stateService = stateService;
    }

    @RequestMapping(value = "/state/create.do", method = RequestMethod.GET)
    public String create() {
        return "admin/config/stateCreate";
    }

    @RequestMapping(value = "/state/all.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("states", this.stateService.findAll());
        return "admin/config/stateList";
    }

    @RequestMapping(value = "/state/save.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("state") State state, Model model) {
        this.stateService.add(state);
        return "redirect:/admin/state/all.do";
    }


    @RequestMapping(value = "/state/{id}/edit.do", method = RequestMethod.GET)
    public String edit( @PathVariable("id") long id,Model model) {
        model.addAttribute("state", this.stateService.findById(id));
        model.addAttribute("id", id);
        return "admin/config/stateEdit";
    }

    @RequestMapping(value = "/state/{id}/edit.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("state") State state,@PathVariable("id") long id,Model model) {
        state.setId(id);
        try {
            this.stateService.update(state);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/state/all.do";
    }

    @RequestMapping(value = "/state/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        State state = (State) this.stateService.findById(id);
        this.stateService.delete(state);
        return "redirect:/admin/state/all.do";
    }
}
