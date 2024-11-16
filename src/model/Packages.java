package model;

/**
 * The Packages class represents a package associated with an order.
 * It contains details such as package ID, cost, weight, dimensions,
 * and the order ID it is linked to.
 */
public class Packages implements HasID {
    private final Integer packageID;
    private double cost;
    private Integer orderID;
    private double weight;
    private String dimensions;

    /*
    Order - Package: Aggregation => order not initialized in the constructor
     */

    /**
     * Constructs a Packages object with the specified details.
     *
     * @param packageID   the unique identifier for this package
     * @param weight      the weight of this package
     * @param dimensions  the dimensions of this package
     * @param cost        the cost associated with this package
     */
    public Packages(Integer packageID, double weight, String dimensions, Integer cost) {
        this.cost = cost;
        this.packageID = packageID;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    /**
     * Gets the cost of this package.
     *
     * @return the cost of the package
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the unique identifier for this package.
     *
     * @return the package ID
     */
    public int getPackageID() {
        return packageID;
    }

    /**
     * Gets the order ID associated with this package.
     *
     * @return the order ID, or null if not set
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the order ID for this package.
     *
     * @param orderID the unique identifier for the order associated with this package
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the weight of this package.
     *
     * @return the weight of the package
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets a new weight for this package.
     *
     * @param weight the new weight of the package
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the dimensions of this package.
     *
     * @return a string representing the dimensions of the package
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * Sets new dimensions for this package.
     *
     * @param dimensions a string representing the new dimensions of the package
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * Returns a string representation of this Packages object,
     * including all its attributes.
     *
     * @return a string representation of this Package
     */
    @Override
    public String toString() {
        return "Package{" +
                "packageID=" + packageID +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                ", cost=" + cost +
                '}';
    }

    /**
     * Gets the unique identifier for this object, as required by HasID interface.
     *
     * @return unique identifier (package ID)
     */
    @Override
    public Integer getId() {
        return packageID;
    }

    public String toCsv() {
        return packageID + "," +
                (orderID != null ? orderID : "null") + "," + // Handle null orderID
                weight + "," +
                dimensions + "," +
                cost;
    }

    public static Packages fromCsv(String csvLine) {
        // Split the input string into parts
        String[] parts = csvLine.split(",");

        // Parse fields
        Integer packageID = Integer.parseInt(parts[0]);
        Integer orderID = parts[1].equals("null") ? null : Integer.parseInt(parts[1]); // Handle null for orderID
        double weight = Double.parseDouble(parts[2]);
        String dimensions = parts[3];
        int cost = Integer.parseInt(parts[4]);

        // Create a new Packages object
        Packages packages = new Packages(packageID, weight, dimensions, cost);

        // Set the orderID if it exists
        if (orderID != null) {
            packages.setOrderID(orderID);
        }

        return packages;
    }
}