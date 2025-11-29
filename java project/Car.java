// Subclass - demonstrates Inheritance and Polymorphism
public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String vehicleId, String brand, String model, double dailyRate, int numberOfSeats) {
        super(vehicleId, brand, model, dailyRate);
        this.numberOfSeats = numberOfSeats;
    }

    // Method Overriding - demonstrates Runtime Polymorphism
    @Override
    public String getVehicleType() {
        return "Car";
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | %s %s | Type: %s | Seats: %d | Rate: $%.2f/day | Status: %s",
                vehicleId, brand, model, getVehicleType(), numberOfSeats, dailyRate, 
                isAvailable ? "Available" : "Rented");
    }
}

