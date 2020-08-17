package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "device_property")
@Entity(name = "device_property")
public class DeviceProperty implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "devic_property_seq")
    @SequenceGenerator(name = "devic_property_seq", sequenceName = "devic_property_seq", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "device_model_property_id")
    private DeviceModelProperty deviceModelProperty;

    @OneToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @Column(name = "threshold", columnDefinition = "number(10,2)")
    private Double threshold;

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

    public DeviceProperty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceModelProperty getDeviceModelProperty() {
        return deviceModelProperty;
    }

    public void setDeviceModelProperty(DeviceModelProperty deviceModelProperty) {
        this.deviceModelProperty = deviceModelProperty;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Double getValue() {
        return threshold;
    }

    public void setValue(Double threshold) {
        this.threshold = threshold;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
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
