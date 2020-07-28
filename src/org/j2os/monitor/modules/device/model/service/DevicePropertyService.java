package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceProperty;
import org.j2os.monitor.modules.device.model.repository.DevicePropertyRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DevicePropertyService implements ServiceInterface<DeviceProperty> {
    private DevicePropertyRepository devicePropertyRepository;

    @Autowired
    public DevicePropertyService(DevicePropertyRepository devicePropertyRepository) {
        this.devicePropertyRepository = devicePropertyRepository;
    }

    @Override
    @Transactional
    public void add(DeviceProperty deviceProperty) {
        this.devicePropertyRepository.save(deviceProperty);
    }

    @Override
    @Transactional
    public void update(DeviceProperty deviceProperty) throws InvocationTargetException, IllegalAccessException {
        DeviceProperty exist = this.devicePropertyRepository.findOne(DeviceProperty.class, deviceProperty.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, deviceProperty);
        this.devicePropertyRepository.save(exist);
    }

    @Override
    public List<DeviceProperty> findAll() {
        return this.devicePropertyRepository.findAll(DeviceProperty.class);
    }

    @Override
    @Transactional
    public void delete(DeviceProperty deviceProperty) {
        this.devicePropertyRepository.delete(deviceProperty);
    }

    @Override
    public DeviceProperty findOne(DeviceProperty deviceProperty) {
        return this.devicePropertyRepository.findOne(DeviceProperty.class, deviceProperty.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.devicePropertyRepository.existsById(DeviceProperty.class, id);
    }

    @Override
    public DeviceProperty findById(long id) {
        return this.devicePropertyRepository.findOne(DeviceProperty.class, id);
    }
}
