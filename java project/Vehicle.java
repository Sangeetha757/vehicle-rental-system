// Base class - demonstrates Inheritance
public class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double dailyRate;
    protected boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Method to be overridden - demonstrates Polymorphism
    public String getVehicleType() {
        return "Vehicle";
    }

    // Method overloading - demonstrates Compile-time Polymorphism
    public double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    public double calculateRentalCost(int days, double discount) {
        return (dailyRate * days) * (1 - discount);
    }

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s | Type: %s | Rate: $%.2f/day | Status: %s",
                vehicleId, brand, model, getVehicleType(), dailyRate, isAvailable ? "Available" : "Rented");
    }
}

