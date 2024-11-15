package model;

import java.util.ArrayList;
import java.util.List;

public class Delivery_Person extends Person {
    private Integer deliveryPersonID;
    private boolean verified;
    private String license;
    private List<Delivery> deliveries;
    private Integer personalVehicleId;


    public Delivery_Person(int deliveryPersonID, String phone, String name) {
        this.name=name;
        this.phone=phone;
        this.deliveryPersonID = deliveryPersonID;
        this.deliveries = new ArrayList<>();
    }

    public String getLicense() {
        return license;
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
/*
    public boolean removeDelivery(Delivery delivery) {
        boolean removed = deliveries.remove(delivery);
        return removed;
    }
*/
    public List<Delivery> getDeliveries() {
    return deliveries;
}
    public void setPersonalVehicleId(Integer personalVehicleId) {
        this.personalVehicleId = personalVehicleId;
    }

    @Override
    public String toString() {
        return "Delivery_Person{" +
                "deliveryPersonID=" + deliveryPersonID +
                ", verified=" + verified +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", personalVehicleId=" + personalVehicleId +
                '}';
    }

    @Override
    public Integer getId() {
        return deliveryPersonID;
    }
}

