package model;

import java.util.List;

public class Deposit implements HasID{
    private final int depositID;
    private int storeID;
    private int packageID;
    private String address;
    private String status;
    private List<Packages> packages;

    /*
    Deposit - Package: Aggregation => packages not initialized in the constructor
    Store - Deposit: Association => store created in the constructor

     */

    public Deposit(int depositID, String address, String status){
        this.depositID = depositID;
        this.address = address;
        this.status = status;
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

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
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
                ", packageID=" + packageID +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", packages=" + packages +
                '}';
    }
    public Integer getId() {
        return depositID;
    }
}
