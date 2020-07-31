package org.j2os.monitor.modules.owner.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="owner")
public class OwnerDevice implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="owner_seq")
    @SequenceGenerator(name="owner_seq", sequenceName="owner_seq", allocationSize=1)
    private long ownerId;

    @Column(columnDefinition = "varchar2(30)")
    private String firstname;

    @Column(columnDefinition = "varchar2(30)")
    private String lastname;

    @Column(columnDefinition = "varchar2(30)")
    private String phonenumber;

    @Column(columnDefinition = "varchar2(30)")
    private String mobilenumber;

    @Column(columnDefinition = "varchar2(70)")
    private String address;

    public OwnerDevice() {
    }

    public OwnerDevice(String firstname, String lastname, String phonenumber, String mobilenumber, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.address = address;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
