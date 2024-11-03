package model;

public class Personal_Vehicle extends Transportation{
    private final int personalVehicleID;
    private int extraFee;
    private int deliveryPersonID;
    private int capacity;
    private Transportation_Type transportation_type;

    /*
    Delivery_Person - Personal_Vehicle: Association => Delivery_Person not initialized in constructor
     */

    public Personal_Vehicle(int personalVehicleID, Integer extraFee, int capacity, Transportation_Type transportationType){
        super(capacity, transportationType);
        this.personalVehicleID = personalVehicleID;
        this.extraFee = extraFee;
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

    @Override
    public String toString() {
        return "Personal_Vehicle{" +
                "personalVehicleID=" + personalVehicleID +
                ", extraFee=" + extraFee +
                ", deliveryPersonID=" + deliveryPersonID +
                '}';
    }
}