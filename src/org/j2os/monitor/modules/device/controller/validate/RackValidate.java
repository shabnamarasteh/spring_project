package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.Rack;
import org.j2os.monitor.modules.device.model.service.RackService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class RackValidate  implements ValidateInterface<Rack> {
    private RackService rackService;

    @Autowired
    public RackValidate(RackService rackService) {
        this.rackService = rackService;
    }

    @Override
    public ValidateObject addValidate(Rack rack) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(rack == null){
            errorList.add("Object is null");
        }else{
            if(rack.getName() == null || rack.getName().isEmpty()){
                errorList.add("Name is required");
            }
            if(rack.getMax_unit() == 0 ){
                errorList.add("MaxUnit is required");
            }
            if(rack.getDatacenterId() == null || rack.getDatacenterId().getId() == 0){
                errorList.add("DataCenter is required");
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
    public ValidateObject updateValidate(Rack rack) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(rack == null || rack.getId() == 0){
            errorList.add("Object is null");
        }else{
            if(!this.rackService.existsById(rack.getId())){
                errorList.add("Rack not defined");
            }else{
                if(rack.getName() != null || rack.getName().isEmpty()){
                    errorList.add("Name is required");
                }
                if(rack.getMax_unit() == 0 ){
                    errorList.add("MaxUnit is required");
                }
                if(rack.getDatacenterId() == null || rack.getDatacenterId().getId() == 0){
                    errorList.add("DataCenter is required");
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
    public ValidateObject deleteValidate(Rack rack) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(rack == null){
            errorList.add("Object is null");
        }else{
            if(!this.rackService.existsById(rack.getId())){
                errorList.add("Rack not defined");
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
    public ValidateObject findOneValidate(Rack rack) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(rack == null){
            errorList.add("Object is null");
        }else{
            if(!this.rackService.existsById(rack.getId())){
                errorList.add("Rack Model not defined");
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
        if(!this.rackService.existsById(id)){
            errorList.add("Rack not defined");
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
