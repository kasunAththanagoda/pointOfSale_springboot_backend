package com.pos.pointOfSale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class OrderDetails {

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;

    @Id
    @Column(name = "order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 10,nullable = false)
    private double qty;

    @Column(name = "amount",nullable = false)
    private double amount;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "items=" + items +
                ", orders=" + orders +
                ", orderDetailsId=" + orderDetailsId +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
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

    public OrderDetails(Item items, Order orders, int orderDetailsId, String itemName, double qty, double amount) {
        this.items = items;
        this.orders = orders;
        this.orderDetailsId = orderDetailsId;
        this.itemName = itemName;
        this.qty = qty;
        this.amount = amount;
    }

    public OrderDetails() {
    }
}
