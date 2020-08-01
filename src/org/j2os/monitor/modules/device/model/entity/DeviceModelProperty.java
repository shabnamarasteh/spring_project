package org.j2os.monitor.modules.device.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "device_model_property")
@Entity
public class DeviceModelProperty implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "device_model_property_seq", sequenceName = "device_model_property_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "device_model_property_seq")
    private Long id;

    @Column(name = "name", columnDefinition = "nvarchar2(200)")
    private String name;

    @OneToOne
    @JoinColumn(name = "device_model_id")
    private DeviceModel deviceModel;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "threshold", columnDefinition = "number(10,2)")
    private Long threshold;

    public DeviceModelProperty() {
    }

    public DeviceModelProperty(String name, DeviceModel deviceModel, String type, String url, Long threshold) {
        this.name = name;
        this.deviceModel = deviceModel;
        this.type = type;
        this.url = url;
        this.threshold = threshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceModel getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }
}
