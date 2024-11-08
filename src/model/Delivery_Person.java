package model;

import java.util.List;

public class Delivery_Person extends Employee{
    private final Integer deliveryPersonID;
    private boolean verified;
    private String phone;
    private String name;
    private String license;
    private List<Delivery> deliveries;


    public Delivery_Person(int deliveryPersonID, boolean verified, String phone, String name, String license) {
        super(name, phone, license);
        this.deliveryPersonID = deliveryPersonID;
        this.verified = verified;
    }

    public int getDeliveryPersonID() {
        return deliveryPersonID;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean removeDelivery(Delivery delivery) {
        boolean removed = deliveries.remove(delivery);
        return removed;
    }

    @Override
    public String toString() {
        return "Delivery_Person{" +
                "deliveryPersonID=" + deliveryPersonID +
                ", verified=" + verified +
                '}';
    }
}

