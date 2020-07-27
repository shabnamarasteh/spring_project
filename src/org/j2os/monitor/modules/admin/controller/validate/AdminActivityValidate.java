package org.j2os.monitor.modules.admin.controller.validate;

import org.j2os.monitor.modules.admin.model.entity.AdminActivity;
import org.j2os.monitor.modules.admin.model.service.AdminActivityService;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class AdminActivityValidate implements ValidateInterface<AdminActivity> {
    private AdminActivityService adminActivityService;

    @Autowired
    public AdminActivityValidate(AdminActivityService adminActivityService) {
        this.adminActivityService = adminActivityService;
    }

    @Override
    public ValidateObject addValidate(AdminActivity adminActivity) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(adminActivity == null){
            errorList.add("Object is null");
        }else{
            if(adminActivity.getActivity() == null || adminActivity.getActivity().isEmpty()){
                errorList.add("Activity is required");
            }
            if(adminActivity.getIpAddress() == null || adminActivity.getIpAddress().isEmpty()){
                errorList.add("IpAddress is required");
            }
            if(adminActivity.getAdmin() == null || adminActivity.getAdmin().getId() == 0){
                errorList.add("Admin is required");
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
    public ValidateObject updateValidate(AdminActivity adminActivity) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(adminActivity == null){
            errorList.add("Object is null");
        }else{
            if(adminActivity.getActivity() == null || adminActivity.getActivity().isEmpty()){
                errorList.add("Activity is required");
            }
            if(adminActivity.getIpAddress() == null || adminActivity.getIpAddress().isEmpty()){
                errorList.add("IpAddress is required");
            }
            if(adminActivity.getAdmin() == null || adminActivity.getAdmin().getId() == 0){
                errorList.add("Admin is required");
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
    public ValidateObject deleteValidate(AdminActivity adminActivity) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(adminActivity == null){
            errorList.add("Object is null");
        }else{
            if(!this.adminActivityService.existsById(adminActivity.getAdminActivityId())){
                errorList.add("AdminActivity not defined");
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
    public ValidateObject findOneValidate(AdminActivity adminActivity) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(adminActivity == null){
            errorList.add("Object is null");
        }else{
            if(!this.adminActivityService.existsById(adminActivity.getAdminActivityId())){
                errorList.add("AdminActivity not defined");
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
        if(!this.adminActivityService.existsById(id)){
            errorList.add("AdminActivity not defined");
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
