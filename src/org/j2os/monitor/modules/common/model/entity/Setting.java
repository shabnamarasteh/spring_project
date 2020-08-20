package org.j2os.monitor.modules.common.model.entity;

import javax.persistence.*;

@Entity(name = "setting")
@Table(name = "setting")
public class Setting {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "setting_seq", sequenceName = "setting_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setting_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(30)")
    private String name;

    @Column(name = "value", columnDefinition = "nvarchar2(30)")
    private String value;

    public Setting() {
    }

    public Setting(String name, String value) {
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
