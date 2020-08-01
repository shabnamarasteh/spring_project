package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.device.model.service.DeviceGroupService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DeviceGroupValidate implements ValidateInterface<DeviceGroup> {
    private DeviceGroupService deviceGroupService;

    @Autowired
    public DeviceGroupValidate(DeviceGroupService deviceGroupService) {
        this.deviceGroupService = deviceGroupService;
    }

    @Override
    public ValidateObject addValidate(DeviceGroup deviceGroup) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (deviceGroup == null) {
            errorList.add("Object is null");
        } else {
            if (deviceGroup.getName() == null || deviceGroup.getName().isEmpty()) {
                errorList.add("Name is required");
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
    public ValidateObject updateValidate(DeviceGroup deviceGroup) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (deviceGroup == null || deviceGroup.getId() == 0) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceGroupService.existsById(deviceGroup.getId())) {
                errorList.add("DeviceGroup not defined");
            } else {
                if (deviceGroup.getName() != null && deviceGroup.getName().isEmpty()) {
                    errorList.add("Name is required");
                }
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
    public ValidateObject deleteValidate(DeviceGroup deviceGroup) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (deviceGroup == null) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceGroupService.existsById(deviceGroup.getId())) {
                errorList.add("DeviceGroup not defined");
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
    public ValidateObject findOneValidate(DeviceGroup deviceGroup) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (deviceGroup == null) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceGroupService.existsById(deviceGroup.getId())) {
                errorList.add("Device not defined");
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
        if (!this.deviceGroupService.existsById(id)) {
            errorList.add("DeviceGroup not defined");
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
