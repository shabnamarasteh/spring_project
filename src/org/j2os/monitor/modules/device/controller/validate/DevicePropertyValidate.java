package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.DeviceProperty;
import org.j2os.monitor.modules.device.model.service.DevicePropertyService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DevicePropertyValidate implements ValidateInterface<DeviceProperty> {
    private DevicePropertyService devicePropertyService;

    @Autowired
    public DevicePropertyValidate(DevicePropertyService devicePropertyService) {
        this.devicePropertyService = devicePropertyService;
    }

    @Override
    public ValidateObject addValidate(DeviceProperty deviceProperty) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceProperty == null){
            errorList.add("Object is null");
        }else{
            if(deviceProperty.getValue() == null){
                errorList.add("Value is required");
            }
            if(deviceProperty.getDateTime() == null ){
                errorList.add("DateTime is required");
            }
            if(deviceProperty.getDevice() == null || deviceProperty.getDevice().getId() == 0){
                errorList.add("Device is required");
            }
            if(deviceProperty.getDeviceModelProperty() == null || deviceProperty.getDeviceModelProperty().getId() == 0){
                errorList.add("Deivce Model Property is required");
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
    public ValidateObject updateValidate(DeviceProperty deviceProperty) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceProperty == null || deviceProperty.getId() == 0){
            errorList.add("Object is null");
        }else{
            if(!this.devicePropertyService.existsById(deviceProperty.getId())){
                errorList.add("DeviceProperty not defined");
            }else{
                if(deviceProperty.getValue() == null){
                    errorList.add("Value is required");
                }
                if(deviceProperty.getDateTime() == null ){
                    errorList.add("DateTime is required");
                }
                if(deviceProperty.getDevice() == null || deviceProperty.getDevice().getId() == 0){
                    errorList.add("Device is required");
                }
                if(deviceProperty.getDeviceModelProperty() == null || deviceProperty.getDeviceModelProperty().getId() == 0){
                    errorList.add("Deivce Model Property is required");
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
    public ValidateObject deleteValidate(DeviceProperty deviceProperty) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceProperty == null){
            errorList.add("Object is null");
        }else{
            if(!this.devicePropertyService.existsById(deviceProperty.getId())){
                errorList.add("DeviceProperty not defined");
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
    public ValidateObject findOneValidate(DeviceProperty deviceProperty) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(deviceProperty == null){
            errorList.add("Object is null");
        }else{
            if(!this.devicePropertyService.existsById(deviceProperty.getId())){
                errorList.add("DeviceProperty not defined");
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
        if(!this.devicePropertyService.existsById(id)){
            errorList.add("DeviceProperty not defined");
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
