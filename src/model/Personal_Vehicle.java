package model;

public class Personal_Vehicle {
    private final int personalVehicleID;
    private int extraFee;
    private int deliveryPersonID;

    /*
    Delivery_Person - Personal_Vehicle: Association => Delivery_Person not initialized in contructor
     */

    public Personal_Vehicle(int personalVehicleID, Integer extraFee){
        this.personalVehicleID = personalVehicleID;
        this.extraFee = extraFee;
    }

    public Personal_Vehicle(int personalVehicleID){
        this.personalVehicleID = personalVehicleID;
    }

    public int getPersonalVehicleID() {
        return personalVehicleID;
    }

    public int getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(int extraFee) {
        this.extraFee = extraFee;
    }

    public int getDeliveryPersonID() {
        return deliveryPersonID;
    }

    public void setDeliveryPersonID(int deliveryPersonID) {
        this.deliveryPersonID = deliveryPersonID;
    }

}
