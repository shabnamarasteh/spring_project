package org.j2os.monitor.modules.common.controller;

import org.j2os.monitor.modules.common.model.entity.Setting;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(value = "/admin/config")
public class SettingController {
    private ServiceInterface settingService;

    @Autowired
    public SettingController(@Qualifier("settingService") ServiceInterface settingService) {
        this.settingService = settingService;
    }

    @RequestMapping(value = "/create.do", method = RequestMethod.GET)
    public String create() {
        return "/admin/config/configCreate";
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("items",this.settingService.findAll());
        return "/admin/config/configList";
    }

    @RequestMapping(value = "/{id}/edit.do", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("setting", this.settingService.findById(id));
        return "/admin/config/configEdit";
    }

    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public String update(@ModelAttribute("setting") Setting setting) {
        try {
            this.settingService.update(setting);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/config/index.do";
    }
    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public String submit(@ModelAttribute("setting") Setting setting) {
        this.settingService.add(setting);
        return "redirect:/admin/config/index.do";
    }

    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") long id, Model model) {
        Setting setting = (Setting) this.settingService.findById(id);
        this.settingService.delete(setting);
        return "redirect:/admin/config/index.do";
    }
}
