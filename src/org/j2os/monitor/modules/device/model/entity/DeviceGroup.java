package org.j2os.monitor.modules.device.model.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "device_group")
@Entity(name = "device_group")
public class DeviceGroup {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "device_model_seq", sequenceName = "device_model_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_model_seq")
    private long deviceGroupId;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @Column(name = "description", columnDefinition = "nvarchar2(200)")
    private String description;

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

    public DeviceGroup() {
    }

    public DeviceGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getDeviceGroupId() {
        return deviceGroupId;
    }

    public void setDeviceGroupId(long deviceGroupid) {
        this.deviceGroupId = deviceGroupid;
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



    public DeviceGroup(String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime createdBy, LocalDateTime updatedBy) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
