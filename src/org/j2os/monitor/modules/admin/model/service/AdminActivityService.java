package org.j2os.monitor.modules.admin.model.service;

import org.j2os.monitor.modules.admin.model.entity.AdminActivity;
import org.j2os.monitor.modules.admin.model.repository.AdminActivityRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AdminActivityService implements ServiceInterface<AdminActivity> {
    private AdminActivityRepository adminActivityRepository;

    @Autowired
    public AdminActivityService(AdminActivityRepository adminActivityRepository) {
        this.adminActivityRepository = adminActivityRepository;
    }

    @Override
    @Transactional
    public void add(AdminActivity adminActivity) {
        this.adminActivityRepository.save(adminActivity);
    }

    @Override
    @Transactional
    public void update(AdminActivity adminActivity) throws InvocationTargetException, IllegalAccessException {
        AdminActivity exist = this.adminActivityRepository.findOne(AdminActivity.class,adminActivity.getAdminActivityId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, adminActivity);
        this.adminActivityRepository.save(exist);
    }

    @Override
    public List<AdminActivity> findAll() {
        return this.adminActivityRepository.findAll(AdminActivity.class);
    }

    @Override
    public AdminActivity findOne(AdminActivity adminActivity) {
        return this.adminActivityRepository.findOne(AdminActivity.class,adminActivity.getAdminActivityId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.adminActivityRepository.existsById(AdminActivity.class,id);
    }

    @Override
    public AdminActivity findById(long id) {
        return this.adminActivityRepository.findOne(AdminActivity.class,id);
    }

    @Override
    @Transactional
    public void delete(AdminActivity adminActivity) {
        this.adminActivityRepository.delete(adminActivity);
    }

}
