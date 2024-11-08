package model;

import java.util.List;

public class Deposit implements HasID{
    private final Integer depositID;
    private Integer storeID;
    private String address;
    private String status;
    private List<Packages> packages;

    /*
    Deposit - Package: Aggregation => packages not initialized in the constructor
    Store - Deposit: Association => store created in the constructor

     */


    public Deposit(int depositID, String address, String status, Integer storeID){
        this.depositID = depositID;
        this.address = address;
        this.status = status;
        this.storeID = storeID;
    }

    public int getDepositID() {
        return depositID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void addPackage(Packages packag) {
        packages.add(packag);
    }

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
    public Integer getId() {
        return depositID;
    }
}
