package model;

import java.sql.Timestamp;
import java.util.List;

public class Delivery implements HasID{
    private final Integer deliveryID;
    private Integer deliveryPeronID;
    private int employeeID;
    private int orderID;
    private int transportationID;
    private Timestamp time;
    private Transportation transportation_type;
    private List<Order> orders;


    /*
    Employee - Delivery: Aggregation => employee not initialized in the constructor
    Delivery - Order: Composition => order initialized in the constructor
    Delivery - Transportation: Association => transportation assigned by setter
     */

    public Delivery(Integer deliveryID, int orderID, Timestamp time){
        this.deliveryID = deliveryID;
        this.orderID = orderID;
        this.time = time;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public Integer getDeliveryPeronID() {
        return deliveryPeronID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getOrderID() {
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

    public void setDeliveryPeronID(Integer deliveryPeronID) {
        this.deliveryPeronID = deliveryPeronID;
    }

    public Transportation getTransportation_type() {
        return transportation_type;
    }

    public void setTransportation_type(Transportation transportation_type) {
        this.transportation_type = transportation_type;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }


    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID=" + deliveryID +
                ", employeeID=" + employeeID +
                ", orderID=" + orderID +
                ", transportationID=" + transportationID +
                ", transportation_type=" + transportation_type +
                '}';
    }
    public Integer getId() {
        return deliveryID;
    }
}
