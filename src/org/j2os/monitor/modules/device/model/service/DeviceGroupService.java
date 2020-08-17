package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceGroup;
import org.j2os.monitor.modules.device.model.repository.DeviceGroupRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Qualifier("deviceGroupService")
public class DeviceGroupService implements ServiceInterface<DeviceGroup> {
    private DeviceGroupRepository deviceGroupRepository;

    @Autowired
    public DeviceGroupService(DeviceGroupRepository deviceGroupRepository) {
        this.deviceGroupRepository = deviceGroupRepository;
    }

    @Override
    @Transactional
    public void add(DeviceGroup deviceGroup) {
        this.deviceGroupRepository.save(deviceGroup);
    }

    @Override
    @Transactional
    public void update(DeviceGroup deviceGroup) throws InvocationTargetException, IllegalAccessException {
        DeviceGroup exist = this.deviceGroupRepository.findOne(DeviceGroup.class, deviceGroup.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, deviceGroup);
        this.deviceGroupRepository.save(exist);
    }

    @Override
    public List<DeviceGroup> findAll() {
        return this.deviceGroupRepository.findAll(DeviceGroup.class);
    }

    @Override
    @Transactional
    public void delete(DeviceGroup deviceGroup) {
        this.deviceGroupRepository.delete(deviceGroup);
    }

    @Override
    public DeviceGroup findOne(DeviceGroup deviceGroup) {
        return this.deviceGroupRepository.findOne(DeviceGroup.class, deviceGroup.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.deviceGroupRepository.existsById(DeviceGroup.class, id);
    }

    @Override
    public DeviceGroup findById(long id) {
        return this.deviceGroupRepository.findOne(DeviceGroup.class, id);
    }
}