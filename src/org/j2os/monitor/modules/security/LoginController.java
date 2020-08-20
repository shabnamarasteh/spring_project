package org.j2os.monitor.modules.security;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.service.AdminMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController{

    private AdminMethodService adminMethodService;

    @Autowired
    public LoginController(AdminMethodService adminMethodService) {
        this.adminMethodService = adminMethodService;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String index() {
        return "/admin/login";
    }

    @RequestMapping(value = "/authenticate.do", method = RequestMethod.POST)
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password
            , RedirectAttributes redirectAttributes) {
//        System.out.println(username + "--------------" + password);
        Admin admin = this.adminMethodService.authenticate(username, password);
        if (admin != null ) {
//            model.addAttribute("adminData",admin);
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("res_error","پست الکترونی یا رمز عبور اشتباه می باشد");
            return "/admin/login";
        }

    }

}
