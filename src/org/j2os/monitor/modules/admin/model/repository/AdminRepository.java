package org.j2os.monitor.modules.admin.model.repository;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.utils.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AdminRepository extends CrudRepository<Admin, Long> {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public Admin authenticate(String username, String password) {
        Query query = entityManager.createQuery("select * from admin where email ="+username+" and password ="+password);
        return (Admin)query.getSingleResult();
    }
}
