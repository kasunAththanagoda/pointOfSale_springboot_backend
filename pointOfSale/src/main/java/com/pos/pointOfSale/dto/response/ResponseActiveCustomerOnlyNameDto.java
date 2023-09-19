package com.pos.pointOfSale.dto.response;

import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class ResponseActiveCustomerOnlyNameDto {

    private String customerName;
    private ArrayList contactNumber;

    public ResponseActiveCustomerOnlyNameDto() {
    }

    public ResponseActiveCustomerOnlyNameDto(String customerName, ArrayList contactNumber) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "ResponseActiveCustomerOnlyName{" +
                "customerName='" + customerName + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }
}
