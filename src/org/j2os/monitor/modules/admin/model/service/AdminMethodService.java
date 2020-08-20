package org.j2os.monitor.modules.admin.model.service;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.admin.model.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("adminMethodService")
public class AdminMethodService {
    private AdminRepository adminRepository;

    @Autowired
    public AdminMethodService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin authenticate(String username, String password) {
        return this.adminRepository.authenticate(username,password);

    }
}
