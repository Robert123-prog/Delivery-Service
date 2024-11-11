package model;

import java.util.List;

public class Delivery_Person extends Employee{
    private final Integer deliveryPersonID;
    private boolean verified;
    private String phone;
    private String name;
    private String license;
    private List<Delivery> deliveries;
    private Integer personalVehicleId;


    public Delivery_Person(int deliveryPersonID, String phone, String name, String license) {
        super(name, phone, license);
        this.deliveryPersonID = deliveryPersonID;
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

    public Integer getPersonalVehicleId() {
        return personalVehicleId;
    }

    public boolean removeDelivery(Delivery delivery) {
        boolean removed = deliveries.remove(delivery);
        return removed;
    }

    public void setPersonalVehicleId(Integer personalVehicleId) {
        this.personalVehicleId = personalVehicleId;
    }

    @Override
    public String toString() {
        return "Delivery_Person{" +
                "deliveryPersonID=" + deliveryPersonID +
                ", verified=" + verified +
                '}';
    }
}

