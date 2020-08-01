package org.j2os.monitor.modules.admin.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_activity")
public class AdminActivity implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "admin_activity_seq", sequenceName = "admin_activity_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_activity_seq")
    private long id;

    @Column(name = "activity", columnDefinition = "varchar2(50)")
    private String activity;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(name = "creation_at")
    private LocalDateTime createDate;

    @Column(name = "ip_address", columnDefinition = "varchar2(20)")
    private String ipAddress;

    public AdminActivity() {
    }

    public AdminActivity(String activity, Admin admin, LocalDateTime createDate, String ipAddress) {
        this.activity = activity;
        this.admin = admin;
        this.createDate = createDate;
        this.ipAddress = ipAddress;
    }

    public long getAdminActivityId() {
        return id;
    }

    public void setAdminActivityId(long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
