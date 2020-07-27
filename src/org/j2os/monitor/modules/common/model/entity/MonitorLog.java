package org.j2os.monitor.modules.common.model.entity;
import org.j2os.monitor.modules.device.model.entity.DeviceProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="city")
public class MonitorLog {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="monitorlog_seq")
    @SequenceGenerator(name="monitorlog_seq", sequenceName="monitorlog_seq", allocationSize=1)
    private long monitorlogId;

    @ManyToOne
    @JoinColumn(name = "device_property_id")
    private DeviceProperty deviceProperty;

    @Column(name = "value" , columnDefinition = "number")
    private String value;

    @Column(name = "creation_at" , updatable = false)
    private LocalDateTime createdAt;

    public MonitorLog(DeviceProperty deviceProperty, String value, LocalDateTime createdAt) {
        this.deviceProperty = deviceProperty;
        this.value = value;
        this.createdAt = createdAt;
    }

    public long getMonitorlogId() {
        return monitorlogId;
    }

    public void setMonitorlogId(long monitorlogId) {
        this.monitorlogId = monitorlogId;
    }

    public DeviceProperty getDeviceProperty() {
        return deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty deviceProperty) {
        this.deviceProperty = deviceProperty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
