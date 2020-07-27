package org.j2os.monitor.modules.admin.controller.validate;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.service.AdminService;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class AdminValidate implements ValidateInterface<Admin> {
    private AdminService adminService;

    @Autowired
    public AdminValidate(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public ValidateObject addValidate(Admin admin) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(admin == null){
            errorList.add("Object is null");
        }else{
            if(admin.getRole_id() == null || admin.getRole_id().getId() == 0){
                errorList.add("Role is required");
            }
            if(admin.getFirstname() == null || admin.getFirstname().isEmpty()){
                errorList.add("FirstName is required");
            }
            if(admin.getLastname() == null || admin.getLastname().isEmpty()){
                errorList.add("LastName is required");
            }
            if(admin.getEmail() == null || admin.getEmail().isEmpty()){
                errorList.add("Email is required");
            }
            if(admin.getPassword() == null || admin.getPassword().isEmpty()){
                errorList.add("Password is required");
            }
        }
        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }

    @Override
    public ValidateObject updateValidate(Admin admin) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(admin == null){
            errorList.add("Object is null");
        }else{
            if(admin.getRole_id() == null || admin.getRole_id().getId() == 0){
                errorList.add("Role is required");
            }
            if(admin.getFirstname() == null || admin.getFirstname().isEmpty()){
                errorList.add("FirstName is required");
            }
            if(admin.getLastname() == null || admin.getLastname().isEmpty()){
                errorList.add("LastName is required");
            }
            if(admin.getEmail() == null || admin.getEmail().isEmpty()){
                errorList.add("Email is required");
            }
            if(admin.getPassword() == null || admin.getPassword().isEmpty()){
                errorList.add("Password is required");
            }
        }
        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }

    @Override
    public ValidateObject findAllValidate() {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();

        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }

    @Override
    public ValidateObject deleteValidate(Admin admin) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(admin == null){
            errorList.add("Object is null");
        }else{
            if(!this.adminService.existsById(admin.getId())){
                errorList.add("Admin not defined");
            }
        }
        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }

    @Override
    public ValidateObject findOneValidate(Admin admin) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(admin == null){
            errorList.add("Object is null");
        }else{
            if(!this.adminService.existsById(admin.getId())){
                errorList.add("Admin not defined");
            }
        }
        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(!this.adminService.existsById(id)){
            errorList.add("Admin not defined");
        }
        validateObject.setFaultmessage(errorList);
        if(errorList.size() >0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }
        return  validateObject;
    }
}
