package org.j2os.monitor.modules.admin.controller.validate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/a.do")
    public String a()throws Exception
    {

//        System.out.println("ana a "+person.getId()+" "+person.getName());
        return "redirect:/one.jsp";//redirect to one.jsp
    }
}
