package org.j2os.monitor.modules.alarm.controller.validate;

import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.modules.alarm.model.service.AlarmNoteService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class AlarmNoteValidate implements ValidateInterface<AlarmNote> {
    private AlarmNoteService alarmNoteService;

    @Autowired
    public AlarmNoteValidate(AlarmNoteService alarmNoteService) {
        this.alarmNoteService = alarmNoteService;
    }

    @Override
    public ValidateObject addValidate(AlarmNote alarmNote) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmNote == null){
            errorList.add("Object is null");
        }else{
            if(alarmNote.getMessage() == null || alarmNote.getMessage().isEmpty()){
                errorList.add("Message is required");
            }
            if(alarmNote.getDeviceProperty() == null || alarmNote.getDeviceProperty().getId() == 0){
                errorList.add("DeviceProperty is required");
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
    public ValidateObject updateValidate(AlarmNote alarmNote) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmNote == null){
            errorList.add("Object is null");
        }else{
            if(alarmNote.getMessage() == null || alarmNote.getMessage().isEmpty()){
                errorList.add("Message is required");
            }
            if(alarmNote.getDeviceProperty() == null || alarmNote.getDeviceProperty().getId() == 0){
                errorList.add("DeviceProperty is required");
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
    public ValidateObject deleteValidate(AlarmNote alarmNote) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmNote == null){
            errorList.add("Object is null");
        }else{
            if(!this.alarmNoteService.existsById(alarmNote.getId())){
                errorList.add("AlarmNote not defined");
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
    public ValidateObject findOneValidate(AlarmNote alarmNote) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmNote == null){
            errorList.add("Object is null");
        }else{
            if(!this.alarmNoteService.existsById(alarmNote.getId())){
                errorList.add("AlarmNote not defined");
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
        if(!this.alarmNoteService.existsById(id)){
            errorList.add("AlarmNote not defined");
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
