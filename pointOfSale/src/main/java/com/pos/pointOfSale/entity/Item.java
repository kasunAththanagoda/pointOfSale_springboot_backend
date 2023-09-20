package com.pos.pointOfSale.entity;

import com.pos.pointOfSale.entity.enums.MeasuringUnits;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "item")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Item {

    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_unit",length = 45,nullable = false)
    private MeasuringUnits measuringUnit;

    @Column(name = "balance_qty",length = 10,nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "activeState",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", measuringUnit=" + measuringUnit +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", activeState=" + activeState +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MeasuringUnits getMeasuringUnit() {
        return measuringUnit;
    }

    public void setMeasuringUnit(MeasuringUnits measuringUnit) {
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

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    public Item(int itemId, String itemName, MeasuringUnits measuringUnit, double balanceQty, double supplierPrice, double sellingPrice, boolean activeState) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measuringUnit = measuringUnit;
        this.balanceQty = balanceQty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeState = activeState;
    }

    public Item() {
    }
}
