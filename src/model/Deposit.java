package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a deposit location for storing packages.
 * This class implements the HasID interface and manages deposit information
 * including its associated store, address, status, and packages.
 * It maintains an aggregation relationship with Package and an association with Store.
 */
public class Deposit implements HasID {
    private final Integer depositID;
    private Integer storeID;
    private String address;
    private String status;
    private List<Packages> packages;

    /**
     * Constructs a new Deposit object.
     * Note:
     * - Deposit-Package: Aggregation relationship
     * - Store-Deposit: Association relationship
     * Initializes an empty list of packages and sets the basic deposit information.
     *
     * @param depositID The unique identifier for the deposit
     * @param address   The physical address of the deposit
     * @param status    The current status of the deposit
     * @param storeID   The ID of the associated store
     */
    public Deposit(int depositID, String address, String status, Integer storeID) {
        this.depositID = depositID;
        this.address = address;
        this.status = status;
        this.storeID = storeID;
        this.packages = new ArrayList<>();
    }

    /**
     * Returns the unique identifier of the deposit.
     *
     * @return The deposit ID
     */
    public Integer getDepositID() {
        return depositID;
    }

    /**
     * Returns the ID of the associated store.
     *
     * @return The store ID
     */
    public Integer getStoreID() {
        return storeID;
    }

    /**
     * Sets the ID of the associated store.
     *
     * @param storeID The new store ID
     */
    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    /**
     * Returns the physical address of the deposit.
     *
     * @return The deposit's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a new address for the deposit.
     *
     * @param address The new physical address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the current status of the deposit.
     *
     * @return The deposit's status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a new status for the deposit.
     *
     * @param status The new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the list of packages stored in this deposit.
     *
     * @return List of Packages objects in this deposit
     */
    public List<Packages> getPackages() {
        return packages;
    }

    /**
     * Adds a new package to the deposit.
     *
     * @param packag The Packages object to be added to the deposit
     */
    public void addPackage(Packages packag) {
        packages.add(packag);
    }

    /**
     * Returns a string representation of the Deposit object.
     *
     * @return A string containing the deposit's ID, store ID, address, status, and list of packages
     */
    @Override
    public String toString() {
        return "Deposit{" +
                "depositID=" + depositID +
                ", storeID=" + storeID +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", packages=" + packages +
                '}';
    }

    /**
     * Returns the ID of this deposit.
     * Implementation of the HasID interface.
     *
     * @return The deposit ID
     */
    public Integer getId() {
        return depositID;
    }
}