package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.Datacenter;
import org.j2os.monitor.modules.device.model.service.DatacenterService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DatacenterValidate implements ValidateInterface<Datacenter> {
    private DatacenterService datacenterService;

    @Autowired
    public DatacenterValidate(DatacenterService datacenterService) {
        this.datacenterService = datacenterService;
    }

    @Override
    public ValidateObject addValidate(Datacenter datacenter) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(datacenter == null){
            errorList.add("Object is null");
        }else{
            if(datacenter.getName() == null || datacenter.getName().isEmpty()){
                errorList.add("Name is required");
            }
            if(datacenter.getCityId() == null || datacenter.getCityId().getId() == 0){
                errorList.add("City is required");
            }
            if(datacenter.getLocation() == null || datacenter.getLocation().isEmpty()){
                errorList.add("Location is required");
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
    public ValidateObject updateValidate(Datacenter datacenter) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(datacenter == null || datacenter.getId() == 0){
            errorList.add("Object is null");
        }else{
            if(!this.datacenterService.existsById(datacenter.getId())){
                errorList.add("DataCenter not defined");
            }else{
                if(datacenter.getName() != null && datacenter.getName().isEmpty()){
                    errorList.add("Name is required");
                }
                if(datacenter.getCityId() != null && datacenter.getCityId().getId() == 0){
                    errorList.add("City is required");
                }
                if(datacenter.getLocation() != null && datacenter.getLocation().isEmpty()){
                    errorList.add("Location is required");
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
    public ValidateObject deleteValidate(Datacenter datacenter) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(datacenter == null){
            errorList.add("Object is null");
        }else{
            if(!this.datacenterService.existsById(datacenter.getId())){
                errorList.add("DataCenter not defined");
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
    public ValidateObject findOneValidate(Datacenter datacenter) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(datacenter == null){
            errorList.add("Object is null");
        }else{
            if(!this.datacenterService.existsById(datacenter.getId())){
                errorList.add("Device not defined");
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
        if(!this.datacenterService.existsById(id)){
            errorList.add("Device not defined");
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
