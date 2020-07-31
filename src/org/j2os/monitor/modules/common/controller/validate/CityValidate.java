package org.j2os.monitor.modules.common.controller.validate;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.common.model.service.CityService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class CityValidate implements ValidateInterface<City> {
    private CityService cityService;

    @Autowired
    public CityValidate(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public ValidateObject addValidate(City city) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(city == null){
            errorList.add("Object is null");
        }else{
            if(city.getName() == null || city.getName().isEmpty()){
                errorList.add("Name is required");
            }
            if(city.getStateId() == null || city.getStateId().getId() == 0){
                errorList.add("State is required");
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
    public ValidateObject updateValidate(City city) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(city == null){
            errorList.add("Object is null");
        }else{
            if(city.getName() == null || city.getName().isEmpty()){
                errorList.add("Name is required");
            }
            if(city.getStateId() == null || city.getStateId().getId() == 0){
                errorList.add("State is required");
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
    public ValidateObject deleteValidate(City city) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(city == null){
            errorList.add("Object is null");
        }else{
            if(!this.cityService.existsById(city.getId())){
                errorList.add("City not defined");
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
    public ValidateObject findOneValidate(City city) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(city == null){
            errorList.add("Object is null");
        }else{
            if(!this.cityService.existsById(city.getId())){
                errorList.add("City not defined");
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
        if(!this.cityService.existsById(id)){
            errorList.add("City not defined");
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
