// Subclass - demonstrates Inheritance and Polymorphism
public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String brand, String model, double dailyRate, double loadCapacity) {
        super(vehicleId, brand, model, dailyRate);
        this.loadCapacity = loadCapacity;
    }

    // Method Overriding - demonstrates Runtime Polymorphism
    @Override
    public String getVehicleType() {
        return "Truck";
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s | Type: %s | Capacity: %.1f tons | Rate: $%.2f/day | Status: %s",
                vehicleId, brand, model, getVehicleType(), loadCapacity, dailyRate, 
                isAvailable ? "Available" : "Rented");
    }
}

