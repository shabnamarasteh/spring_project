package org.j2os.monitor.modules.device.controller.validate;

import org.j2os.monitor.modules.utils.ValidateObject;
import org.j2os.monitor.modules.device.model.entity.Device;
import org.j2os.monitor.modules.device.model.service.DeviceService;
import org.j2os.monitor.modules.utils.Interfaces.validate.ValidateInterface;
import org.j2os.monitor.modules.utils.annotation.ValidationAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ValidationAnnotation
public class DeviceValidate implements ValidateInterface<Device> {
    private DeviceService deviceService;

    @Autowired
    public DeviceValidate(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public ValidateObject addValidate(Device device) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (device == null) {
            errorList.add("Object is null");
        } else {
            if (device.getDeviceMode() == null || device.getDeviceMode().getId() == 0) {
                errorList.add("Device Model is required");
            }
            if (device.getName() == null || device.getName().isEmpty()) {
                errorList.add("Name is required");
            }
            if (device.getIpAddress() == null || device.getIpAddress().isEmpty()) {
                errorList.add("Ip Address is required");
            }
            if (device.getOwnerDevice() == null || device.getOwnerDevice().getOwnerId() == 0) {
                errorList.add("Owner is required");
            }
            if (device.getRackId() == null || device.getRackId().getId() == 0) {
                errorList.add("Rack is required");
            }
            if (device.getStartUnit() == 0) {
                errorList.add("StartUnit is required");
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
    public ValidateObject updateValidate(Device device) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (device == null || device.getId() == 0) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceService.existsById(device.getId())) {
                errorList.add("Device not defined");
            } else {

                if (device.getDeviceMode() != null && device.getDeviceMode().getId() == 0) {
                    errorList.add("Device Model is required");
                }
                if (device.getName() != null && device.getName().isEmpty()) {
                    errorList.add("Name is required");
                }
                if (device.getIpAddress() != null && device.getIpAddress().isEmpty()) {
                    errorList.add("Ip Address is required");
                }
                if (device.getOwnerDevice() != null && device.getOwnerDevice().getOwnerId() == 0) {
                    errorList.add("Owner is required");
                }
                if (device.getRackId() != null && device.getRackId().getId() == 0) {
                    errorList.add("Rack is required");
                }
                if (device.getStartUnit() == 0) {
                    errorList.add("StartUnit is required");
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
    public ValidateObject deleteValidate(Device device) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (device == null) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceService.existsById(device.getId())) {
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
    public ValidateObject findOneValidate(Device device) {
        ValidateObject validateObject = new ValidateObject();
        List<String> errorList = new ArrayList<>();
        if (device == null) {
            errorList.add("Object is null");
        } else {
            if (!this.deviceService.existsById(device.getId())) {
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
        if (!this.deviceService.existsById(id)) {
            errorList.add("Device not defined");
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
