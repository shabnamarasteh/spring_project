package org.j2os.monitor.modules.device.model.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "device_group")
@Entity
public class DeviceGroup {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "device_model_seq", sequenceName = "device_model_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_model_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @Column(name = "description", columnDefinition = "nvarchar2(200)")
    private String description;

    public DeviceGroup() {
    }

    public DeviceGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
