package com.pos.pointOfSale.dto.request;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class RequestOrderSaveDto {

//  order entity eke tbna tka
//    private Customer customer;
//    private Set<OrderDetails> orderDetails;
//    private int orderId;
//    private Date date;
//    private double total;

    private int customer; //enne customer id ek wtri
    private Date date;
    private double total;
//    private Set<OrderDetails> orderDetails; meke list ekk enne
    private List<RequestOrderDetailsSave> orderDetails;

    @Override
    public String toString() {
        return "RequestOrderSaveDto{" +
                "customer=" + customer +
                ", date=" + date +
                ", total=" + total +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<RequestOrderDetailsSave> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RequestOrderDetailsSave> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public RequestOrderSaveDto(int customer, Date date, double total, List<RequestOrderDetailsSave> orderDetails) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public RequestOrderSaveDto() {
    }
}
