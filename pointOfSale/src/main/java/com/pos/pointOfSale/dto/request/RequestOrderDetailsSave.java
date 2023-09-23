package com.pos.pointOfSale.dto.request;


public class RequestOrderDetailsSave {

//    private Item items; mwge id enne
//    private Order orders;  mwge id enne
//    private int orderDetailsId;  mka ewn na frontend ekn
//    private String itemName;
//    private double qty;
//    private double amount;



    private int items;
//    private int orders;
    private String itemName;
    private double qty;
    private double amount;

    @Override
    public String toString() {
        return "RequestOrderDetailsSave{" +
                "items=" + items +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RequestOrderDetailsSave(int items, String itemName, double qty, double amount) {
        this.items = items;
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
    }

    public RequestOrderDetailsSave() {
    }
}
