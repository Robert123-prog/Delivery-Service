package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Order class represents a customer's order in the system.
 * It contains details such as order ID, customer ID, order date,
 * delivery date and time, cost, status, and associated packages.
 */
public class Order implements HasID {
    private final Integer orderID;
    private Integer customerID;
    private Date orderDate;
    protected LocalDateTime deliveryDateTime;
    private double totalCost;
    private String status;
    private List<Packages> packages;

    /*
    Order - Package: Aggregation => packages not initialized in the constructor
    Order - Customer: Association => customer will be added by the setter
     */

    /**
     * Constructs an Order with the specified details.
     *
     * @param orderID         the unique identifier for this order
     * @param orderDate       the date when the order was placed
     * @param deliveryDateTime the date and time when the order is to be delivered
     * @param /totalCost            the total cost of the order
     * @param /status          the current status of the order
     */
    public Order(Integer orderID, Date orderDate, LocalDateTime deliveryDateTime) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.deliveryDateTime = deliveryDateTime;
        //this.totalCost = totalCost;
        //this.status = status;
        this.packages = new ArrayList<>();
    }

    /**
     * Gets the unique identifier for this order.
     *
     * @return the order ID
     */
    public Integer getOrderID() {
        return orderID;
    }

    /**
     * Gets the customer ID associated with this order.
     *
     * @return the customer ID
     */
    public Integer getCustomerID() {
        return customerID;
    }

    /**
     * Sets the customer ID for this order.
     *
     * @param customerID the unique identifier for the customer placing this order
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Gets the date when this order was placed.
     *
     * @return the order date
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date when this order was placed.
     *
     * @param orderDate the new date for this order
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the delivery date and time for this order.
     *
     * @return the delivery date and time
     */
    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    /**
     * Sets the delivery date and time for this order.
     *
     * @param deliveryDateTime the new delivery date and time
     */
    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    /**
     * Gets the total cost of this order.
     *
     * @return the cost of the order
     */
    public double getCost() {
        return totalCost;
    }

    /**
     * Sets a new total cost for this order.
     *
     * @param cost the new total cost of the order
     */
    public void setCost(double cost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets the current status of this order.
     *
     * @return the status of the order
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a new status for this order.
     *
     * @param status the new status of the order
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets a list of packages associated with this order.
     *
     * @return a list of packages in this order
     */
    public List<Packages> getPackages() {
        return packages;
    }

    /**
     * Adds a package to this order.
     *
     * @param packag the package to be added to this order
     */
    public void addPackage(Packages packag) {
        packages.add(packag);
    }

    /**
     * Returns a string representation of this Order object,
     * including all its attributes.
     *
     * @return a string representation of this Order
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDateTime +
                ", cost=" + totalCost +
                ", status='" + status + '\'' +
                ", packages=" + packages +
                '}';
    }

    /**
     * Gets the unique identifier for this object, as required by HasID interface.
     *
     * @return unique identifier (order ID)
     */
    @Override
    public Integer getId() {
        return orderID;
    }
}