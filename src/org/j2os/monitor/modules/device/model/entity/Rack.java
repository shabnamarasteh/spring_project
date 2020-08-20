package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "rack")
@Table(name = "rack")
public class Rack implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "rack_seq", sequenceName = "rack_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rack_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "datacenter_id")
    private Datacenter datacenterId;

    @Column(name = "max_unit", columnDefinition = "number")
    private long maxUnit;

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

    public Rack(String id) {
        if(id != null){
            this.id = Long.parseLong(id);
        }
    }

    public Rack(String name, Datacenter datacenterId, long maxUnit) {
        this.name = name;
        this.datacenterId = datacenterId;
        this.maxUnit = maxUnit;
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

    public Datacenter getDatacenterId() {
        return datacenterId;
    }

    public void setDatacenterId(Datacenter datacenterId) {
        this.datacenterId = datacenterId;
    }

    public long getMaxUnit() {
        return maxUnit;
    }

    public void setMaxUnit(long maxUnit) {
        this.maxUnit = maxUnit;
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
