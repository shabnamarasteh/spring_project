package org.j2os.monitor.modules.common.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "city_seq", sequenceName = "city_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(30)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State stateId;

    public City() {
    }

    public City(String name, State stateId) {
        this.name = name;
        this.stateId = stateId;
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

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }
}
