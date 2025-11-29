// Subclass - demonstrates Inheritance and Polymorphism
public class Motorcycle extends Vehicle {
    private int engineCC;

    public Motorcycle(String vehicleId, String brand, String model, double dailyRate, int engineCC) {
        super(vehicleId, brand, model, dailyRate);
        this.engineCC = engineCC;
    }

    // Method Overriding - demonstrates Runtime Polymorphism
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    public int getEngineCC() {
        return engineCC;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s | Type: %s | Engine: %dcc | Rate: $%.2f/day | Status: %s",
                vehicleId, brand, model, getVehicleType(), engineCC, dailyRate, 
                isAvailable ? "Available" : "Rented");
    }
}

