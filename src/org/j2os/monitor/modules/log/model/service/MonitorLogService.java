package org.j2os.monitor.modules.log.model.service;

import org.j2os.monitor.modules.log.model.entity.MonitorLog;
import org.j2os.monitor.modules.log.model.repository.MonitorLogRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class MonitorLogService implements ServiceInterface<MonitorLog> {
    private MonitorLogRepository monitorLogRepository;

    @Autowired
    public MonitorLogService(MonitorLogRepository monitorLogRepository) {
        this.monitorLogRepository = monitorLogRepository;
    }

    @Override
    public void add(MonitorLog monitorLog) {
        this.monitorLogRepository.save(monitorLog);
    }

    @Override
    public void update(MonitorLog monitorLog) throws InvocationTargetException, IllegalAccessException {
        MonitorLog exist = this.monitorLogRepository.findOne(MonitorLog.class, monitorLog.getMonitorlogId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, monitorLog);
        this.monitorLogRepository.save(exist);
    }

    @Override
    public List<MonitorLog> findAll() {
        return this.monitorLogRepository.findAll(MonitorLog.class);
    }

    @Override
    public void delete(MonitorLog monitorLog) {
        this.monitorLogRepository.delete(monitorLog);
    }

    @Override
    public MonitorLog findOne(MonitorLog monitorLog) {
        return this.monitorLogRepository.findOne(MonitorLog.class, monitorLog.getMonitorlogId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.monitorLogRepository.existsById(MonitorLog.class, id);
    }

    @Override
    public MonitorLog findById(long id) {
        return this.monitorLogRepository.findOne(MonitorLog.class, id);
    }
}
