package com.pos.pointOfSale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs(
        @TypeDef(name = "json",typeClass = JsonType.class)
)
public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    private int customerId;

    @Column(name = "customer_name",length = 100, nullable = false)
    private String customerName;

    @Column(name = "cutomer_address",length = 150)
    private String customerAddress;

    @Column(name = "customer_salary",length = 10)
    private double salary;

    @Type(type = "json")
    @Column(name = "contactNumber",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name="nic",length = 12,unique = true)
    private String nic;

    @Column(name = "activeStatus",columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, double salary, ArrayList contactNumber, String nic, boolean activeStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.activeStatus = activeStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
