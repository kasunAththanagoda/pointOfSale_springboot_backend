package com.pos.pointOfSale.dto.request;



public class CustomerUpdateQueryRequestDto {
    private String customerName;
    private String nic;

    public CustomerUpdateQueryRequestDto() {
    }

    public CustomerUpdateQueryRequestDto(String customerName, String nic) {
        this.customerName = customerName;
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "CustomerUpdateQueryRequestDto{" +
                "customerName='" + customerName + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
