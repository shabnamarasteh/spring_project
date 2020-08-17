package org.j2os.monitor.modules.device.model.service;

import org.j2os.monitor.modules.device.model.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private DeviceRepository deviceRepository;

    @Autowired
    public TestService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

}
