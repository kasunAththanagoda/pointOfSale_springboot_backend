package com.pos.pointOfSale.dto.request;

//import lombok.*;

import java.util.ArrayList;
//@AllArgsConstructor
//@NoArgsConstructor
//////@Getter
//////@Setter
//////@ToString
//@Data
public class CustomerUpdateRequestDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private double salary;
    private ArrayList contactNumber;
    private String nic;
    private boolean activeStatus;

    public CustomerUpdateRequestDTO() {
    }

    public CustomerUpdateRequestDTO(int customerId, String customerName, String customerAddress, double salary, ArrayList contactNumber, String nic, boolean activeStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "CustomerUpdateRequestDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
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
}
