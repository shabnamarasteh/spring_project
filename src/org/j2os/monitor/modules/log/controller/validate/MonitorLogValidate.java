package org.j2os.monitor.modules.log.controller.validate;

import org.j2os.monitor.modules.device.model.entity.DeviceProperty;
import org.j2os.monitor.modules.device.model.service.DevicePropertyService;
import org.j2os.monitor.modules.log.model.entity.MonitorLog;
import org.j2os.monitor.modules.log.model.service.MonitorLogService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class MonitorLogValidate implements ValidateInterface<MonitorLog> {
    private MonitorLogService monitorLogService;
    private DevicePropertyService devicePropertyService;

    @Autowired
    public MonitorLogValidate(MonitorLogService monitorLogService, DevicePropertyService devicePropertyService) {
        this.monitorLogService = monitorLogService;
        this.devicePropertyService = devicePropertyService;
    }

    @Override
    public ValidateObject addValidate(MonitorLog monitorLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if(monitorLog == null){
            errorList.add("Object is null");
        }else{
            if(monitorLog.getDeviceProperty() == null){
                errorList.add("DeviceProperty Object is null");
            }else{
                if (this.devicePropertyService.existsById(monitorLog.getDeviceProperty().getId())){
                    errorList.add("DeviceProperty is not found");
                }
                if(monitorLog.getValue() == null || monitorLog.getValue() < 0){
                    errorList.add("Name is required");
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
    public ValidateObject updateValidate(MonitorLog monitorLog) {
        return null;
    }

    @Override
    public ValidateObject findAllValidate() {
        return null;
    }

    @Override
    public ValidateObject deleteValidate(MonitorLog monitorLog) {
        return null;
    }

    @Override
    public ValidateObject findOneValidate(MonitorLog monitorLog) {
        return null;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        return null;
    }
}
