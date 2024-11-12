/**
 * Represents a store in the delivery management system.
 * This class implements the HasID interface and manages store information
 * including store details and associated deposits.
 *
 * Relationships:
 * - Store - Deposit: Association (deposits list initialized in constructor)
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Store implements HasID {
    /** Unique identifier for the store */
    private final Integer storeID;

    /** Name of the store */
    private String name;

    /** Physical address of the store */
    private String address;

    /** Contact information for the store */
    private String contact;

    /** List of deposits associated with this store */
    private List<Deposit> deposits;

    /**
     * Constructs a new Store with the specified details.
     * Initializes an empty list of deposits.
     *
     * @param storeID Unique identifier for the store
     * @param name Name of the store
     * @param address Physical address of the store
     * @param contact Contact information for the store
     */
    public Store(Integer storeID, String name, String address, String contact) {
        this.storeID = storeID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.deposits = new ArrayList<>();
    }

    /**
     * Returns the store's unique identifier.
     *
     * @return The store's ID
     */
    public int getStoreID() {
        return storeID;
    }

    /**
     * Returns the store's name.
     *
     * @return The name of the store
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the store's name.
     *
     * @param name New name for the store
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the store's address.
     *
     * @return The physical address of the store
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the store's address.
     *
     * @param address New address for the store
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the store's contact information.
     *
     * @return The contact information for the store
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the store's contact information.
     *
     * @param contact New contact information for the store
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Returns the list of deposits associated with this store.
     *
     * @return List of store's deposits
     */
    public List<Deposit> getDeposits() {
        return deposits;
    }

    /**
     * Adds a new deposit to the store's deposit list.
     *
     * @param deposit Deposit to be added to the store's deposits
     */
    public void addDeposit(Deposit deposit) {
        deposits.add(deposit);
    }

    /**
     * Returns a string representation of the Store object.
     * Includes store ID, name, address, contact information, and associated deposits.
     *
     * @return String representation of the store
     */
    @Override
    public String toString() {
        return "Store{" +
                "storeID=" + storeID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", deposits=" + deposits +
                '}';
    }

    /**
     * Implementation of HasID interface.
     * Returns the store's unique identifier.
     *
     * @return The store's ID
     */
    @Override
    public Integer getId() {
        return storeID;
    }
}