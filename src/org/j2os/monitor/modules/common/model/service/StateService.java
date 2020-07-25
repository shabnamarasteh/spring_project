package org.j2os.monitor.modules.common.model.service;

import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.modules.common.model.repository.StateRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class StateService implements ServiceInterface<State> {
    private StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    @Transactional
    public void add(State state) {
        this.stateRepository.save(state);
    }

    @Override
    @Transactional
    public void update(State state) throws InvocationTargetException, IllegalAccessException {
        State exist = this.stateRepository.findOne(State.class,state.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, state);
        this.stateRepository.save(exist);
    }

    @Override
    public List<State> findAll() {
        return this.stateRepository.findAll(State.class);
    }

    @Override
    @Transactional
    public void delete(State state) {
        this.stateRepository.delete(state);
    }

    @Override
    public State findOne(State state) {
        return this.stateRepository.findOne(State.class,state.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.stateRepository.existsById(State.class,id);
    }

    @Override
    public State findById(long id) {
        return this.stateRepository.findOne(State.class,id);
    }
}
