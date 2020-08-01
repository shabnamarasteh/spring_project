package org.j2os.monitor.modules.alarm.controller.validate;

import org.j2os.monitor.modules.alarm.model.entity.AlarmLog;
import org.j2os.monitor.modules.alarm.model.service.AlarmLogService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class AlarmLogValidate implements ValidateInterface<AlarmLog> {
    private AlarmLogService alarmLogService;

    @Autowired
    public AlarmLogValidate(AlarmLogService alarmLogService) {
        this.alarmLogService = alarmLogService;
    }

    @Override
    public ValidateObject addValidate(AlarmLog alarmLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmLog == null){
            errorList.add("Object is null");
        }else{
            if(alarmLog.getMessage() == null || alarmLog.getMessage().isEmpty()){
                errorList.add("Message is required");
            }
            if(alarmLog.getAdmin() == null || alarmLog.getAdmin().getId() == 0){
                errorList.add("Admin is required");
            }
            if(alarmLog.getAlarm_note_id() == null || alarmLog.getAlarm_note_id().getId() == 0){
                errorList.add("Alarm_note_id is required");
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
    public ValidateObject updateValidate(AlarmLog alarmLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmLog == null){
            errorList.add("Object is null");
        }else{
            if(alarmLog.getMessage() == null || alarmLog.getMessage().isEmpty()){
                errorList.add("Message is required");
            }
            if(alarmLog.getAdmin() == null || alarmLog.getAdmin().getId() == 0){
                errorList.add("Admin is required");
            }
            if(alarmLog.getAlarm_note_id() == null || alarmLog.getAlarm_note_id().getId() == 0){
                errorList.add("Alarm_note_id is required");
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
    public ValidateObject deleteValidate(AlarmLog alarmLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmLog == null){
            errorList.add("Object is null");
        }else{
            if(!this.alarmLogService.existsById(alarmLog.getAlarmLogId())){
                errorList.add("AlarmLog not defined");
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
    public ValidateObject findOneValidate(AlarmLog alarmLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(alarmLog == null){
            errorList.add("Object is null");
        }else{
            if(!this.alarmLogService.existsById(alarmLog.getAlarmLogId())){
                errorList.add("AlarmLog not defined");
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
        if(!this.alarmLogService.existsById(id)){
            errorList.add("AlarmLog not defined");
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
