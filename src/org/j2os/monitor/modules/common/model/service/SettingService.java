package org.j2os.monitor.modules.common.model.service;

import org.j2os.monitor.modules.common.model.entity.Setting;
import org.j2os.monitor.modules.common.model.repository.SettingRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class SettingService  implements ServiceInterface<Setting> {
    private SettingRepository settingRepository;

    @Autowired
    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    @Transactional
    public void add(Setting setting) {
        this.settingRepository.save(setting);
    }

    @Override
    @Transactional
    public void update(Setting setting) throws InvocationTargetException, IllegalAccessException {
        Setting exist = this.settingRepository.findOne(Setting.class,setting.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, setting);
        this.settingRepository.save(exist);
    }

    @Override
    public List<Setting> findAll() {
        return this.settingRepository.findAll(Setting.class);
    }

    @Override
    @Transactional
    public void delete(Setting setting) {
        this.settingRepository.delete(setting);
    }

    @Override
    public Setting findOne(Setting setting) {
        return this.settingRepository.findOne(Setting.class,setting.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.settingRepository.existsById(Setting.class,id);
    }

    @Override
    public Setting findById(long id) {
        return this.settingRepository.findOne(Setting.class,id);
    }

}
