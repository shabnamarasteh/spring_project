package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.entity.DeviceModel;
import org.j2os.monitor.modules.device.model.repository.DeviceModelRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class DeviceModelService implements ServiceInterface<DeviceModel> {
    private DeviceModelRepository deviceModelRepository;

    @Autowired
    public DeviceModelService(DeviceModelRepository deviceModelRepository) {
        this.deviceModelRepository = deviceModelRepository;
    }

    @Override
    @Transactional
    public void add(DeviceModel deviceModel) {
        this.deviceModelRepository.save(deviceModel);
    }

    @Override
    @Transactional
    public void update(DeviceModel deviceModel) throws InvocationTargetException, IllegalAccessException {
        DeviceModel exist = this.deviceModelRepository.findOne(DeviceModel.class, deviceModel.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, deviceModel);
        this.deviceModelRepository.save(exist);
    }

    @Override
    public List<DeviceModel> findAll() {
        return this.deviceModelRepository.findAll(DeviceModel.class);

    }

    @Override
    @Transactional
    public void delete(DeviceModel deviceModel) {
        this.deviceModelRepository.delete(deviceModel);
    }

    @Override
    public DeviceModel findOne(DeviceModel deviceModel) {
        return this.deviceModelRepository.findOne(DeviceModel.class, deviceModel.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.deviceModelRepository.existsById(DeviceModel.class, id);
    }

    @Override
    public DeviceModel findById(long id) {
        return this.deviceModelRepository.findOne(DeviceModel.class, id);
    }
}
