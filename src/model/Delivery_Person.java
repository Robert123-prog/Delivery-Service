package model;

public class Delivery_Person extends Employee{
    private final Integer deliveryPersonID;
    private boolean verified;

    public Delivery_Person(Integer deliveryPersonID, boolean verified){
        //good use of super ??
        super(deliveryPersonID);
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

    @Override
    public String toString() {
        return "Delivery_Person{" +
                "deliveryPersonID=" + deliveryPersonID +
                ", verified=" + verified +
                '}';
    }
}

