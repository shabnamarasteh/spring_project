package org.j2os.monitor.modules.alarm.model.entity;

import org.j2os.monitor.modules.admin.model.entity.Admin;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alarmLog")
public class AlarmLog {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "alarmlog_seq", sequenceName = "alarmlog_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alarmlog_seq")
    private long alarmLogId;

    @ManyToOne
    @JoinColumn(name = "alarm_note_id")
    private AlarmNote alarm_note_id;

    @Column(name = "message", columnDefinition = "nvarchar2(200)")
    private String message;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

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

    public AlarmLog() {
    }

    public AlarmLog(AlarmNote alarm_note_id, String message, Admin admin) {
        this.alarm_note_id = alarm_note_id;
        this.message = message;
        this.admin = admin;
    }

    public long getAlarmLogId() {
        return alarmLogId;
    }

    public void setAlarmLogId(long alarmLogId) {
        this.alarmLogId = alarmLogId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AlarmNote getAlarm_note_id() {
        return alarm_note_id;
    }

    public void setAlarm_note_id(AlarmNote alarm_note_id) {
        this.alarm_note_id = alarm_note_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
