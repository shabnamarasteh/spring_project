package org.j2os.monitor.modules.log.model.entity;

import org.j2os.monitor.modules.device.model.entity.DeviceProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitor_log")
public class MonitorLog {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "monitor_log_seq", sequenceName = "monitor_log_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monitor_log_seq")
    private long Id;

    @ManyToOne
    @JoinColumn(name = "device_property_id")
    private DeviceProperty deviceProperty;

    @Column(name = "value", columnDefinition = "number(10,2)")
    private Double value;

    @Column(name = "creation_at", updatable = false)
    private LocalDateTime createdAt;

    public MonitorLog() {
    }

    public MonitorLog(DeviceProperty deviceProperty, Double value, LocalDateTime createdAt) {
        this.deviceProperty = deviceProperty;
        this.value = value;
        this.createdAt = createdAt;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public DeviceProperty getDeviceProperty() {
        return deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty deviceProperty) {
        this.deviceProperty = deviceProperty;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
