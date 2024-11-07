package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order implements HasID{
    private final int orderID;
    private int customerID;
    private Date orderDate;
    protected LocalDateTime deliveryDateTime;
    private double cost;
    private String status;
    private List<Packages> packages;

    /*
    Order - Package: Aggregation => packages not initialized in the constructor
    Order - Customer: Association => customer will be added by the setter
     */

    public Order(int orderID, Date orderDate, LocalDateTime deliveryDateTime, double cost, String status){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.deliveryDateTime = deliveryDateTime;
        this.cost = cost;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Packages> getPackages() {
        return packages;
    }

    public void setPackages(List<Packages> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDateTime +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", packages=" + packages +
                '}';
    }
    public Integer getId() {
        return orderID;
    }
}
