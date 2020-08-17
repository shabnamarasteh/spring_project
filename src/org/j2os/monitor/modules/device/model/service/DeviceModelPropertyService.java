package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceModelProperty;
import org.j2os.monitor.modules.device.model.repository.DeviceModelPropertyRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Qualifier("deviceModelPropertyService")
public class DeviceModelPropertyService implements ServiceInterface<DeviceModelProperty> {
    private DeviceModelPropertyRepository deviceModelPropertyRepository;

    @Autowired
    public DeviceModelPropertyService(DeviceModelPropertyRepository deviceModelPropertyRepository) {
        this.deviceModelPropertyRepository = deviceModelPropertyRepository;
    }

    @Override
    @Transactional
    public void add(DeviceModelProperty deviceModelProperty) {
        this.deviceModelPropertyRepository.save(deviceModelProperty);
    }

    @Override
    @Transactional
    public void update(DeviceModelProperty deviceModelProperty) throws InvocationTargetException, IllegalAccessException {
        DeviceModelProperty exist = this.deviceModelPropertyRepository.findOne(DeviceModelProperty.class, deviceModelProperty.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, deviceModelProperty);
        this.deviceModelPropertyRepository.save(exist);
    }

    @Override
    public List<DeviceModelProperty> findAll() {
        return this.deviceModelPropertyRepository.findAll(DeviceModelProperty.class);

    }

    @Override
    @Transactional
    public void delete(DeviceModelProperty deviceModelProperty) {
        this.deviceModelPropertyRepository.delete(deviceModelProperty);
    }

    @Override
    public DeviceModelProperty findOne(DeviceModelProperty deviceModelProperty) {
        return this.deviceModelPropertyRepository.findOne(DeviceModelProperty.class, deviceModelProperty.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.deviceModelPropertyRepository.existsById(DeviceModelProperty.class, id);
    }

    @Override
    public DeviceModelProperty findById(long id) {
        return this.deviceModelPropertyRepository.findOne(DeviceModelProperty.class, id);
    }
}
