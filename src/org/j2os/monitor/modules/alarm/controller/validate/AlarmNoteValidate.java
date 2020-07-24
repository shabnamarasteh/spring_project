package org.j2os.monitor.modules.alarm.controller.validate;

import org.j2os.monitor.modules.alarm.model.entity.AlarmNote;
import org.j2os.monitor.modules.alarm.model.service.AlarmNoteService;
import org.j2os.monitor.modules.common.model.entity.ValidateObject;
import org.j2os.monitor.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.utils.annotation.ValidationAnnotation;
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
        List<String> errorList = new ArrayList<>();
        ValidateObject validateObject = new ValidateObject();
//
//        if(datacenter == null || datacenter.getName() == null || datacenter.getName().isEmpty()){
//            errorList.add("Name is required");
//        }
//        if(datacenter == null || datacenter.getLocation() == null || datacenter.getLocation().isEmpty()){
//            errorList.add("Location is required");
//        }
//        if(datacenter == null || datacenter.getCityId() == null || datacenter.getCityId().getId() == 0){
//            errorList.add("City Id is required");
//        }
        if(errorList.size()>0){
            validateObject.setResult("error");
        }else{
            validateObject.setResult("success");
        }

        validateObject.setFaultmessage(errorList);
        return validateObject;
    }

    @Override
    public ValidateObject updateValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findAllValidate() {
        return null;
    }

    @Override
    public ValidateObject deleteValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findOneValidate(AlarmNote alarmNote) {
        return null;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        return null;
    }
}
