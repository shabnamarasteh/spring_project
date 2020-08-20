package org.j2os.monitor.modules.common.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "state")
@Table(name = "state")
public class State {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "state_seq", sequenceName = "state_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(30)")
    private String name;

    @Column(name = "creation_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "creation_by", updatable = false)
    private LocalDateTime createdBy;

    @Column(name = "updated_by")
    private LocalDateTime updatedBy;

    @PrePersist
    protected void onCreatedAt() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdatedAt() {
        updatedAt = LocalDateTime.now();
    }

    public State() {
    }

    public State(String id) {
        if(id != null){
            this.id = Long.parseLong(id);
        }
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(LocalDateTime updatedBy) {
        this.updatedBy = updatedBy;
    }
}
