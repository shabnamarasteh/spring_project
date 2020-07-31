package org.j2os.monitor.modules.device.model.entity;

import org.j2os.monitor.modules.owner.model.entity.OwnerDevice;

import javax.persistence.*;

@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="device_seq")
    @SequenceGenerator(name="device_seq", sequenceName="device_seq", allocationSize=1)
    private long id;

    @Column(columnDefinition = "varchar2(200)")
    private String name;

    @Column(columnDefinition = "varchar2(30)")
    private String ip_address;

    @ManyToOne
    @JoinColumn(name = "device_model_id")
    private DeviceModel deviceModelId;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private OwnerDevice owner;

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rackId;

    @Column(name = "start_unit", columnDefinition = "number")
    private long start_unit;

    public Device() {
    }

    public Device(String name, String ip_address, DeviceModel deviceModelId, OwnerDevice owner, Rack rackId, long start_unit) {
        this.name = name;
        this.ip_address = ip_address;
        this.deviceModelId = deviceModelId;
        this.owner = owner;
        this.rackId = rackId;
        this.start_unit = start_unit;
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

    public OwnerDevice getOwner() {
        return owner;
    }

    public void setOwner(OwnerDevice owner) {
        this.owner = owner;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public DeviceModel getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(DeviceModel deviceModelId) {
        this.deviceModelId = deviceModelId;
    }



    public Rack getRackId() {
        return rackId;
    }

    public void setRackId(Rack rackId) {
        this.rackId = rackId;
    }

    public long getStart_unit() {
        return start_unit;
    }

    public void setStart_unit(long start_unit) {
        this.start_unit = start_unit;
    }
}
