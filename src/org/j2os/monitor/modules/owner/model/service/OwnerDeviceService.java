package org.j2os.monitor.modules.owner.model.service;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;
import org.j2os.monitor.modules.owner.model.repository.OwnerDeviceRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class OwnerDeviceService implements ServiceInterface<OwnerDevice> {
    private OwnerDeviceRepository ownerDeviceRepository;
    @Autowired
    public OwnerDeviceService(OwnerDeviceRepository ownerDeviceRepository) {
        this.ownerDeviceRepository = ownerDeviceRepository;
    }

    @Override
    @Transactional
    public void add(OwnerDevice ownerDevice) {
        this.ownerDeviceRepository.save(ownerDevice);
    }

    @Override
    @Transactional
    public void update(OwnerDevice ownerDevice) throws InvocationTargetException, IllegalAccessException {
        OwnerDevice exist = this.ownerDeviceRepository.findOne(OwnerDevice.class,ownerDevice.getOwnerId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, ownerDevice);
        this.ownerDeviceRepository.save(exist);
    }

    @Override
    public List<OwnerDevice> findAll() {
        return this.ownerDeviceRepository.findAll(OwnerDevice.class);
    }

    @Override
    public OwnerDevice findOne(OwnerDevice ownerDevice) {
        return this.ownerDeviceRepository.findOne(OwnerDevice.class,ownerDevice.getOwnerId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.ownerDeviceRepository.existsById(OwnerDevice.class,id);
    }

    @Override
    public OwnerDevice findById(long id) {
        return this.ownerDeviceRepository.findOne(OwnerDevice.class,id);

    }

    @Override
    @Transactional
    public void delete(OwnerDevice ownerDevice) {
        this.ownerDeviceRepository.delete(ownerDevice);
    }

}

