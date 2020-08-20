package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "device_model")
@Entity(name = "device_model")
public class DeviceModel {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "device_model_seq", sequenceName = "device_model_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_model_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @Column(name = "model", columnDefinition = "nvarchar2(200)")
    private String model;

    @Column(name = "description", columnDefinition = "nvarchar2(200)")
    private String description;

    @Column(columnDefinition = "number")
    private long max_unit;

    @Column(columnDefinition = "nvarchar2(200)")
    private String cover;

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

    public DeviceModel(String id) {
        if(id != null){
            this.id = Long.parseLong(id);
        }
    }

    public DeviceModel() {
    }

    public DeviceModel(String name, String model, String description, long max_unit, String cover) {
        this.name = name;
        this.model = model;
        this.description = description;
        this.max_unit = max_unit;
        this.cover = cover;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMax_unit() {
        return max_unit;
    }

    public void setMax_unit(long max_unit) {
        this.max_unit = max_unit;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
