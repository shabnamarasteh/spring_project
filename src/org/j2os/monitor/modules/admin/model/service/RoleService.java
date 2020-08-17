package org.j2os.monitor.modules.admin.model.service;

import org.j2os.monitor.modules.admin.model.entity.Role;
import org.j2os.monitor.modules.admin.model.repository.RoleRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@Qualifier("roleService")
public class RoleService implements ServiceInterface<Role> {
    private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void add(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    @Transactional
    public void update(Role role) throws InvocationTargetException, IllegalAccessException {
        Role exist = this.roleRepository.findOne(Role.class,role.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, role);
        this.roleRepository.save(exist);
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll(Role.class);
    }

    @Override
    public Role findOne(Role role) {
        return this.roleRepository.findOne(Role.class,role.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.roleRepository.existsById(Role.class,id);
    }

    @Override
    public Role findById(long id) {
        return this.roleRepository.findOne(Role.class,id);

    }

    @Override
    @Transactional
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }

}

