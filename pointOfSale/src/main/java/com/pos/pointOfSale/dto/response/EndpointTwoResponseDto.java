package com.pos.pointOfSale.dto.response;

import java.util.ArrayList;

public class EndpointTwoResponseDto {
    private int customerId;
    private String customerAddress;
    private double salary;

    public EndpointTwoResponseDto(int customerId, String customerAddress, double salary) {
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.salary = salary;
    }

    public EndpointTwoResponseDto() {
    }

    @Override
    public String toString() {
        return "EndpointTwoResponseDto{" +
                "customerId=" + customerId +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
}
