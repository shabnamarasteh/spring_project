package org.j2os.monitor.modules.common.model.repository;

import org.j2os.monitor.modules.common.model.entity.Setting;
import org.j2os.monitor.modules.utils.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepository  extends CrudRepository<Setting,Long> {
}

