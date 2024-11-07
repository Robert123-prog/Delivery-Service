package model;

public class Packages implements HasID{
    private final int packageID;
    private int orderID;
    private double weight;
    private String dimensions;

    /*
    Order - Package: Aggregation => order not initialized in the constructor
     */

    public Packages(int packageID, double weight, String dimensions){
        this.packageID = packageID;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public int getPackageID() {
        return packageID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageID=" + packageID +
                ", orderID=" + orderID +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }
    public Integer getId() {
        return packageID;
    }
}
