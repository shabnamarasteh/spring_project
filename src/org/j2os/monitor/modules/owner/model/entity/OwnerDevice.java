package org.j2os.monitor.modules.owner.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owner")
public class OwnerDevice implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "number")
    @SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq")
    private long ownerId;

    @Column(name = "first_name", columnDefinition = "nvarchar2(30)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "nvarchar2(30)")
    private String lastName;

    @Column(name = "phone_number", columnDefinition = "nvarchar2(30)")
    private String phoneNumber;

    @Column(name = "mobile_number", columnDefinition = "nvarchar2(30)")
    private String mobileNumber;

    @Column(name = "address", columnDefinition = "nvarchar2(70)")
    private String address;

    public OwnerDevice() {
    }

    public OwnerDevice(String firstName, String lastName, String phoneNumber, String mobileNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
