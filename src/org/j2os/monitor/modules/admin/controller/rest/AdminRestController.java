package org.j2os.monitor.modules.admin.controller.rest;

import org.j2os.monitor.modules.admin.controller.validate.AdminValidate;
import org.j2os.monitor.modules.admin.controller.validate.RoleValidate;
import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.admin.model.service.AdminService;
import org.j2os.monitor.modules.admin.model.service.RoleService;
import org.j2os.monitor.modules.utils.ApiResponse;
import org.j2os.monitor.modules.utils.Interfaces.controller.RestControllerInterface;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/v1/admin/admin")
public class AdminRestController implements RestControllerInterface {
    private AdminService adminService;
    private AdminValidate adminValidate;
    private RoleValidate roleValidate;
    private RoleService roleService;

    @Autowired
    public AdminRestController(AdminService adminService, AdminValidate adminValidate,RoleValidate roleValidate,
                               RoleService roleService) {
        this.adminService = adminService;
        this.adminValidate = adminValidate;
        this.roleValidate = roleValidate;
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll() {
        ValidateObject validateObject = this.adminValidate.findAllValidate();
        if (validateObject.getResult().equals("error")) {
            return new ApiResponse("Error", 102, validateObject.getFaultmessage()).getFaultResponse();
        }
        List<Admin> adminList = this.adminService.findAll();
        return new ApiResponse("Success", adminList).getSuccessResponse();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object addOne(@RequestBody Admin admin) {
        admin.setId(null);
        ValidateObject validateObject = this.adminValidate.addValidate(admin);
        if (validateObject.getResult().equals("error")) {
            return new ApiResponse("Error", 102, validateObject.getFaultmessage()).getFaultResponse();
        }
        admin.setRoleId(this.roleService.findOne(admin.getRoleId()));
        this.adminService.add(admin);
        return new ApiResponse("Success", Arrays.asList(admin)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object updateOne(@PathVariable("id") Long id, @RequestBody Admin admin) {
        admin.setId(id);
        ValidateObject validateObject = this.adminValidate.updateValidate(admin);
        if (validateObject.getResult().equals("error")) {
            return new ApiResponse("Error", 102, validateObject.getFaultmessage()).getFaultResponse();
        }
        Role role = this.roleService.findOne(admin.getRoleId());
//        ValidateObject validateObjectRole = this.roleValidate.findOneValidate(role);
//        if (validateObjectRole.getResult().equals("error")) {
//            return new ApiResponse("Error", 102, validateObjectRole.getFaultmessage()).getFaultResponse();
//        }

        try {
            admin.setRoleId(role);
            this.adminService.update(admin);
            return new ApiResponse("Success", Arrays.asList(admin)).getSuccessResponse();
        } catch (InvocationTargetException e) {
            return new ApiResponse("Error", 103, Arrays.asList("An error occurred Try again later"))
                    .getFaultResponse();
        } catch (IllegalAccessException e) {
            return new ApiResponse("Error", 104, Arrays.asList("An error occurred Try again later"))
                    .getFaultResponse();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object deleteOne(@PathVariable("id") Long id) {
        Admin admin = new Admin();
        admin.setId(id);
        ValidateObject validateObject = this.adminValidate.deleteValidate(admin);
        if (validateObject.getResult().equals("error")) {
            return new ApiResponse("Error", 102, validateObject.getFaultmessage()).getFaultResponse();
        }
        this.adminService.delete(admin);
        return new ApiResponse("Success", Arrays.asList(admin)).getSuccessResponse();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") Long id) {
        Admin admin = new Admin();
        admin.setId(id);
        ValidateObject validateObject = this.adminValidate.findOneValidate(admin);
        if (validateObject.getResult().equals("error")) {
            return new ApiResponse("Error", 102, validateObject.getFaultmessage()).getFaultResponse();
        }
         return new ApiResponse("Success", Arrays.asList(this.adminService.findOne(admin))).getSuccessResponse();
    }

}