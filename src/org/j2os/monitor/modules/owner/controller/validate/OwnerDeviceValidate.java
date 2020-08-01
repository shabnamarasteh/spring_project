package org.j2os.monitor.modules.owner.controller.validate;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;
import org.j2os.monitor.modules.owner.model.service.OwnerDeviceService;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class OwnerDeviceValidate  implements ValidateInterface<OwnerDevice> {
    private OwnerDeviceService ownerDeviceService;

    @Autowired
    public OwnerDeviceValidate(OwnerDeviceService ownerDeviceService) {
        this.ownerDeviceService = ownerDeviceService;
    }

    @Override
    public ValidateObject addValidate(OwnerDevice ownerDevice) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(ownerDevice == null){
            errorList.add("Object is null");
        }else{
            if(ownerDevice.getFirstname() == null || ownerDevice.getFirstname().isEmpty()){
                errorList.add("FirstName is required");
            }
            if(ownerDevice.getLastname() == null || ownerDevice.getLastname().isEmpty()){
                errorList.add("Lastname is required");
            }
            if(ownerDevice.getMobilenumber() == null || ownerDevice.getMobilenumber().isEmpty()){
                errorList.add("Mobilenumber is required");
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
    public ValidateObject updateValidate(OwnerDevice ownerDevice) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(ownerDevice == null){
            errorList.add("Object is null");
        }else{
            if(ownerDevice.getFirstname() == null || ownerDevice.getFirstname().isEmpty()){
                errorList.add("FirstName is required");
            }
            if(ownerDevice.getLastname() == null || ownerDevice.getLastname().isEmpty()){
                errorList.add("Lastname is required");
            }
            if(ownerDevice.getMobilenumber() == null || ownerDevice.getMobilenumber().isEmpty()){
                errorList.add("Mobilenumber is required");
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
    public ValidateObject deleteValidate(OwnerDevice ownerDevice) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(ownerDevice == null){
            errorList.add("Object is null");
        }else{
            if(!this.ownerDeviceService.existsById(ownerDevice.getOwnerId())){
                errorList.add("OwnerDevice not defined");
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
    public ValidateObject findOneValidate(OwnerDevice ownerDevice) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(ownerDevice == null){
            errorList.add("Object is null");
        }else{
            if(!this.ownerDeviceService.existsById(ownerDevice.getOwnerId())){
                errorList.add("OwnerDevice not defined");
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
        if(!this.ownerDeviceService.existsById(id)){
            errorList.add("OwnerDevice not defined");
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
