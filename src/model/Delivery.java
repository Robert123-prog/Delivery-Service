package model;

import java.sql.Timestamp;

public class Delivery {
    private final int deliveryID;
    private int employeeID;
    private int orderID;
    private int transportationID;
    private Timestamp time;
    private Transportation transportation_type;

    /*
    Employee - Delivery: Aggregation => employee not initialized in the constructor
    Delivery - Order: Composition => order initialized in the constructor
    Delivery - Transportation: Association => transportation assigned by setter
     */

    public Delivery(int deliveryID, int orderID, Timestamp time){
        this.deliveryID = deliveryID;
        this.orderID = orderID;
        this.time = time;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTransportationID() {
        return transportationID;
    }

    public void setTransportationID(int transportationID) {
        this.transportationID = transportationID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Transportation getTransportation_type() {
        return transportation_type;
    }

    public void setTransportation_type(Transportation transportation_type) {
        this.transportation_type = transportation_type;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID=" + deliveryID +
                ", employeeID=" + employeeID +
                ", orderID=" + orderID +
                ", transportationID=" + transportationID +
                ", time=" + time +
                ", transportation_type=" + transportation_type +
                '}';
    }
}
