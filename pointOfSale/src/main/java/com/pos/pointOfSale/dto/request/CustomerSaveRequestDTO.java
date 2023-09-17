package com.pos.pointOfSale.dto.request;

import java.util.ArrayList;

public class CustomerSaveRequestDTO {
    private String customerName;
    private String customerAddress;
    private double salary;
    private ArrayList contactNumber;
    private String nic;

    public CustomerSaveRequestDTO() {
    }

    public CustomerSaveRequestDTO(String customerName, String customerAddress, double salary, ArrayList contactNumber, String nic) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.nic = nic;
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

    @Override
    public String toString() {
        return "CustomerSaveRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                '}';
    }
}
