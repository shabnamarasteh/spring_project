package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.service.DeviceModelService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DeviceModelValidate implements ValidateInterface<DeviceModel> {
    private DeviceModelService deviceModelService;

    @Autowired
    public DeviceModelValidate(DeviceModelService deviceModelService) {
        this.deviceModelService = deviceModelService;
    }

    @Override
    public ValidateObject addValidate(DeviceModel deviceModel) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceModel == null){
            errorList.add("Object is null");
        }else{
            if(deviceModel.getName() == null || deviceModel.getName().isEmpty()){
                errorList.add("Name is required");
            }
            if(deviceModel.getCover() == null ){
                errorList.add("Cover is required");
            }
            if(deviceModel.getMax_unit() == 0){
                errorList.add("MaxUnit is required");
            }
            if(deviceModel.getDevice() == null || deviceModel.getDevice().getId() == 0){
                errorList.add("Deivce is required");
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
    public ValidateObject updateValidate(DeviceModel deviceModel) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceModel == null || deviceModel.getId() == 0){
            errorList.add("Object is null");
        }else{
            if(!this.deviceModelService.existsById(deviceModel.getId())){
                errorList.add("DeviceModel not defined");
            }else{
                if(deviceModel.getName() != null || deviceModel.getName().isEmpty()){
                    errorList.add("Name is required");
                }
                if(deviceModel.getCover() == null ){
                    errorList.add("Cover is required");
                }
                if(deviceModel.getMax_unit() == 0){
                    errorList.add("MaxUnit is required");
                }
                if(deviceModel.getDevice() == null || deviceModel.getDevice().getId() == 0){
                    errorList.add("Deivce is required");
                }
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
    public ValidateObject deleteValidate(DeviceModel deviceModel) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceModel == null){
            errorList.add("Object is null");
        }else{
            if(!this.deviceModelService.existsById(deviceModel.getId())){
                errorList.add("DeviceModel not defined");
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
    public ValidateObject findOneValidate(DeviceModel deviceModel) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceModel == null){
            errorList.add("Object is null");
        }else{
            if(!this.deviceModelService.existsById(deviceModel.getId())){
                errorList.add("Device Model not defined");
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
        if(!this.deviceModelService.existsById(id)){
            errorList.add("DeviceModel not defined");
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
