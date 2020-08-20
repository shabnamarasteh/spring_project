package org.j2os.monitor.modules.common.model.service;

import org.j2os.monitor.modules.common.model.entity.City;
import org.j2os.monitor.modules.common.model.entity.State;
import org.j2os.monitor.modules.common.model.repository.CityRepository;
import org.j2os.monitor.modules.utils.Interfaces.service.ServiceInterface;
import org.j2os.monitor.modules.utils.MyBeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class CityService implements ServiceInterface<City> {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public void add(City city) {
        this.cityRepository.save(city);
    }

    @Override
    @Transactional
    public void update(City city) throws InvocationTargetException, IllegalAccessException {
        City exist = this.cityRepository.findOne(City.class,city.getId());
        MyBeanCopy myBeanCopy = new MyBeanCopy();
        myBeanCopy.copyProperties(exist, city);
        this.cityRepository.save(exist);
    }

    @Override
    public List<City> findAll() {
        return this.cityRepository.findAll(City.class);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.cityRepository.delete(city);
    }

    @Override
    public City findOne(City city) {
        return this.cityRepository.findOne(City.class,city.getId());
    }

    @Override
    public Boolean existsById(long id) {
        return this.cityRepository.existsById(City.class,id);
    }

    @Override
    public City findById(long id) {
        return this.cityRepository.findOne(City.class,id);
    }

}
