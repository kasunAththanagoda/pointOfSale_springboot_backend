package com.pos.pointOfSale.dto.request;

import com.pos.pointOfSale.entity.enums.MeasuringUnits;

public class ItemSaveRequestDto {

    private String itemName;
    private String measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

    @Override
    public String toString() {
        return "ItemSaveRequestDto{" +
                "itemName='" + itemName + '\'' +
                ", measuringUnit='" + measuringUnit + '\'' +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(String measuringUnit) {
        this.measuringUnit = measuringUnit;
    }

    public double getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(double balanceQty) {
        this.balanceQty = balanceQty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public ItemSaveRequestDto(String itemName, String measuringUnit, double balanceQty, double supplierPrice, double sellingPrice) {
        this.itemName = itemName;
        this.measuringUnit = measuringUnit;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
    }

    public ItemSaveRequestDto() {
    }
}
