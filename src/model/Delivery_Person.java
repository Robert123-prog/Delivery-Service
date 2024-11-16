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

    public void addDelivery(Delivery delivery){
        deliveries.add(delivery);
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

    public String toCsv(){
        StringBuilder serializedDeliveries = new StringBuilder();

        for (Delivery delivery: deliveries){
            serializedDeliveries.append(delivery.toCsv()).append(";");
        }

        return deliveryPersonID + "," +
                verified + "," +
                license + "," +
                personalVehicleId + "," + serializedDeliveries.toString();
    }

    public Delivery_Person fromCsv(String csvLine){
        String[] parts = csvLine.split(",", 5); // Split into 5 parts: ID, verified, license, deliveries, vehicle ID

        Integer deliveryPersonID = Integer.parseInt(parts[0]);
        boolean verified = Boolean.parseBoolean(parts[1]);
        String license = parts[2];
        String deliveriesString = parts[3]; // Serialized deliveries
        Integer personalVehicleId = Integer.parseInt(parts[4]);

        // Create a new Delivery_Person object
        Delivery_Person deliveryPerson = new Delivery_Person(deliveryPersonID, "", ""); // Phone and name left empty
        deliveryPerson.setVerified(verified);
        deliveryPerson.license = license;
        deliveryPerson.setPersonalVehicleId(personalVehicleId);

        // Parse deliveries from the deliveriesString
        if (!deliveriesString.isEmpty()) {
            String[] deliveryParts = deliveriesString.split(";");
            for (String deliveryString : deliveryParts) {
                Delivery delivery = Delivery.fromCsv(deliveryString);
                deliveryPerson.addDelivery(delivery);
            }
        }

        return deliveryPerson;
    }
}

