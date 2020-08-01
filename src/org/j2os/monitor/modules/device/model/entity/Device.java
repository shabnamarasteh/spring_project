package org.j2os.monitor.modules.device.model.entity;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "device_seq", sequenceName = "device_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_seq")
    private long id;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @Column(name = "ip_address", columnDefinition = "nvarchar2(30)")
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "device_model_id")
    private DeviceModel deviceMode;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private OwnerDevice ownerDevice;

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rackId;

    @Column(name = "start_unit", columnDefinition = "number")
    private long startUnit;

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

    public Device() {
    }

    public Device(String name, String ipAddress, DeviceModel deviceMode, OwnerDevice ownerDevice, Rack rackId, long startUnit) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.deviceMode = deviceMode;
        this.ownerDevice = ownerDevice;
        this.rackId = rackId;
        this.startUnit = startUnit;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public DeviceModel getDeviceMode() {
        return deviceMode;
    }

    public void setDeviceMode(DeviceModel deviceMode) {
        this.deviceMode = deviceMode;
    }

    public OwnerDevice getOwnerDevice() {
        return ownerDevice;
    }

    public void setOwnerDevice(OwnerDevice ownerDevice) {
        this.ownerDevice = ownerDevice;
    }

    public Rack getRackId() {
        return rackId;
    }

    public void setRackId(Rack rackId) {
        this.rackId = rackId;
    }

    public long getStartUnit() {
        return startUnit;
    }

    public void setStartUnit(long startUnit) {
        this.startUnit = startUnit;
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
