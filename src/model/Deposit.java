package model;

import java.util.Date;
import java.util.List;

public class Deposit {
    private final int depositID;
    private int storeID;
    private int packageID;
    private String address;
    private Date depositDate;
    private String status;
    private List<Package> packages;

    /*
    Deposit - Package: Aggregation => packages not initialized in the constructor
    Store - Deposit: Association => store created in the constructor

     */

    public Deposit(int depositID, String address, Date depositDate, String status){
        this.depositID = depositID;
        this.address = address;
        this.depositDate = depositDate;
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

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}
