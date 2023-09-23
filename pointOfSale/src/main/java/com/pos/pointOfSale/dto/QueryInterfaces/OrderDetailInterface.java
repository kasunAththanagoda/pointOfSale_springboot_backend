package com.pos.pointOfSale.dto.QueryInterfaces;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {
//    private String customerName;
//    private String customerAddress;
//    private ArrayList contactNumber;
//
//
//    private Date date;
//    private double total;

     String getCustomerName();
     String getCustomerAddress();
     ArrayList getContactNumber();
     Date getDate();
     double getTotal();


}
