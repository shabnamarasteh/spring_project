package org.j2os.monitor.modules.common.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "state_seq", sequenceName = "state_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(30)")
    private String name;

    public State() {
    }

    public State(String name) {
        this.name = name;
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
}
