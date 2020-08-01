package org.j2os.monitor.modules.admin.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private long id;

    @Column(name = "name", columnDefinition = "varchar2(200)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar2(500)")
    private String description;

    @Column(name = "is_manager", columnDefinition = "number(1)")
    private Integer isManager = 0;

    public Role() {
    }

    public Role(String name, String description, Integer isManager) {
        this.name = name;
        this.description = description;
        this.isManager = isManager;
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

    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }
}
