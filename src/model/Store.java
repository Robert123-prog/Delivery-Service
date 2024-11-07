package model;

import java.util.ArrayList;
import java.util.List;

public class Store implements HasID{
    private final int storeID;
    private String name;
    private String address;
    private String contact;
    private List<Deposit> deposits;

    /*
    Store - Deposit: Association => deposits created in the constructor
     */
    public Store(int storeID, String name, String address, String contact){
        this.storeID = storeID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.deposits = new ArrayList<>();
    }

    public int getStoreID() {
        return storeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void addDeposit(Deposit deposit) {
        deposits.add(deposit);
    }

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
    public Integer getId() {
        return storeID;
    }
}
