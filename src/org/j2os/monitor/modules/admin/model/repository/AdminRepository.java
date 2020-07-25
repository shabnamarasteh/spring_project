package org.j2os.monitor.modules.admin.model.repository;

import org.j2os.monitor.modules.admin.model.entity.Admin;
import org.j2os.monitor.modules.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository extends CrudRepository<Admin, Long> {
}
