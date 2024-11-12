/**
 * Represents a customer in the delivery management system.
 * This class implements the HasID interface and manages customer information
 * including personal details and associated orders.
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements HasID {
    /** Unique identifier for the customer */
    private final Integer customerID;

    /** Name of the customer */
    private String name;

    /** Physical address of the customer */
    private String address;

    /** Contact phone number of the customer */
    private String phone;

    /** Email address of the customer */
    private String email;

    /** List of orders associated with this customer */
    private List<Order> orders;

    /**
     * Constructs a new Customer with the specified details.
     * Initializes an empty list of orders.
     *
     * @param customerID Unique identifier for the customer
     * @param name Name of the customer
     * @param address Physical address of the customer
     * @param phone Contact phone number
     * @param email Email address
     */
    public Customer(Integer customerID, String name, String address, String phone, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    /**
     * Returns the customer's ID.
     *
     * @return The customer's unique identifier
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Returns the customer's name.
     *
     * @return The customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name.
     *
     * @param name New name for the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the customer's address.
     *
     * @return The customer's physical address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the customer's address.
     *
     * @param address New address for the customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the customer's phone number.
     *
     * @return The customer's contact phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the customer's phone number.
     *
     * @param phone New phone number for the customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the customer's email address.
     *
     * @return The customer's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the customer's email address.
     *
     * @param email New email address for the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the list of orders associated with this customer.
     *
     * @return List of customer's orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Adds a new order to the customer's order list.
     *
     * @param order Order to be added to the customer's orders
     */
    public void addDOrder(Order order) {
        orders.add(order);
    }

    /**
     * Returns a string representation of the Customer object.
     * Includes all customer details and their orders.
     *
     * @return String representation of the customer
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }

    /**
     * Implementation of HasID interface.
     * Returns the customer's unique identifier.
     *
     * @return The customer's ID
     */
    @Override
    public Integer getId() {
        return customerID;
    }
}