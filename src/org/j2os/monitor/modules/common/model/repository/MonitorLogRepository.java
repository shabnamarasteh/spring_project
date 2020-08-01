package org.j2os.monitor.modules.common.model.repository;

import org.j2os.monitor.modules.log.model.entity.MonitorLog;
import org.j2os.monitor.modules.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MonitorLogRepository extends CrudRepository<MonitorLog,Long> {
}

