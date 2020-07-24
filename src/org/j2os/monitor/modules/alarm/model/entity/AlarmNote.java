package org.j2os.monitor.modules.alarm.model.entity;

import org.hibernate.annotations.ForeignKey;
import org.j2os.monitor.modules.device.model.entity.DeviceProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class AlarmNote {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="alarmnote_seq")
    @SequenceGenerator(name="alarmnote_seq", sequenceName="alarmnote_seq", allocationSize=1)
    private long id;

    @ManyToOne
    @JoinColumn(name = "Device_Property_id")
    private DeviceProperty deviceProperty;
    private String name;
    private String message;

    @OneToMany(mappedBy = "alarm_note_id")
    private List<AlarmLog> alarmLogList;

    public AlarmNote() {
    }

    public AlarmNote(DeviceProperty deviceProperty, String name, String message, List<AlarmLog> alarmLogList) {
        this.deviceProperty = deviceProperty;
        this.name = name;
        this.message = message;
        this.alarmLogList = alarmLogList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DeviceProperty getDeviceProperty() {
        return deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty deviceProperty) {
        this.deviceProperty = deviceProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AlarmLog> getAlarmLogList() {
        return alarmLogList;
    }

    public void setAlarmLogList(List<AlarmLog> alarmLogList) {
        this.alarmLogList = alarmLogList;
    }
}
