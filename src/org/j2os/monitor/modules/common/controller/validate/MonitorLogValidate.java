package org.j2os.monitor.modules.common.controller.validate;

import org.j2os.monitor.modules.common.model.service.MonitorLogService;
import org.j2os.monitor.modules.log.model.entity.MonitorLog;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class MonitorLogValidate implements ValidateInterface<MonitorLog> {
    private MonitorLogService monitorLogService;

    @Autowired
    public MonitorLogValidate(MonitorLogService monitorLogService) {
        this.monitorLogService = monitorLogService;
    }

    @Override
    public ValidateObject addValidate(MonitorLog monitorLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (monitorLog == null) {
            errorList.add("Object is null");
        } else {
            if (monitorLog.getValue() == null || monitorLog.getValue() < 0) {
                errorList.add("Value is required");
            }
            if (monitorLog.getDeviceProperty() == null || monitorLog.getDeviceProperty().getId() == 0) {
                errorList.add("DeviceProperty is required");
            }
        }
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject updateValidate(MonitorLog monitorLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (monitorLog == null) {
            errorList.add("Object is null");
        } else {
            if (monitorLog.getValue() == null || monitorLog.getValue() < 0) {
                errorList.add("Value is required");
            }
            if (monitorLog.getDeviceProperty() == null || monitorLog.getDeviceProperty().getId() == 0) {
                errorList.add("DeviceProperty is required");
            }
        }
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findAllValidate() {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject deleteValidate(MonitorLog monitorLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (monitorLog == null) {
            errorList.add("Object is null");
        } else {
            if (!this.monitorLogService.existsById(monitorLog.getId())) {
                errorList.add("MonitorLog not defined");
            }
        }
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findOneValidate(MonitorLog monitorLog) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (monitorLog == null) {
            errorList.add("Object is null");
        } else {
            if (!this.monitorLogService.existsById(monitorLog.getId())) {
                errorList.add("MonitorLog not defined");
            }
        }
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }

    @Override
    public ValidateObject findByIdValidate(long id) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (!this.monitorLogService.existsById(id)) {
            errorList.add("MonitorLog not defined");
        }
        validateObject.setFaultmessage(errorList);
        if (errorList.size() > 0) {
            validateObject.setResult("error");
        } else {
            validateObject.setResult("success");
        }
        return validateObject;
    }
}
