package org.j2os.monitor.modules.admin.controller.validate;

import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.admin.model.service.RoleService;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class RoleValidate implements ValidateInterface<Role> {
    private RoleService roleService;

    @Autowired
    public RoleValidate(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public ValidateObject addValidate(Role role) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(role == null){
            errorList.add("Object is null");
        }else{
            if(role.getName() == null || role.getName().isEmpty()){
                errorList.add("Name is required");
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
    public ValidateObject updateValidate(Role role) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(role == null){
            errorList.add("Object is null");
        }else{
            if(role.getName() == null || role.getName().isEmpty()){
                errorList.add("Name is required");
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
    public ValidateObject deleteValidate(Role role) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(role == null){
            errorList.add("Object is null");
        }else{
            if(!this.roleService.existsById(role.getId())){
                errorList.add("Role not defined");
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
    public ValidateObject findOneValidate(Role role) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(role == null){
            errorList.add("Object is null");
        }else{
            if(!this.roleService.existsById(role.getId())){
                errorList.add("Role not defined");
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
        if(!this.roleService.existsById(id)){
            errorList.add("Role not defined");
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
