package model;

public class Transportation extends Personal_Vehicle{
    private final int transportationID;
    private int capacity;
    private Transportation_Type transportationType;

    public Transportation(int transportationID, int capacity){
        super(transportationID);
        this.transportationID = transportationID;
        this.capacity = capacity;
    }

    public int getTransportationID() {
        return transportationID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Transportation_Type getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(Transportation_Type transportationType) {
        this.transportationType = transportationType;
    }
}
