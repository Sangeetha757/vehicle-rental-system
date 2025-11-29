import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {
    private ArrayList<Vehicle> vehicles;
    private Scanner scanner;

    public RentalSystem() {
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeVehicles();
    }

    private void initializeVehicles() {
        // Polymorphism: Parent class reference (Vehicle) holding child class objects
        vehicles.add(new Car("V001", "Toyota", "Camry", 50.0, 5));
        vehicles.add(new Car("V002", "Honda", "Civic", 45.0, 5));
        vehicles.add(new Car("V003", "Ford", "Mustang", 80.0, 4));
        vehicles.add(new Motorcycle("V004", "Yamaha", "R1", 60.0, 1000));
        vehicles.add(new Motorcycle("V005", "Honda", "CBR", 55.0, 600));
        vehicles.add(new Truck("V006", "Ford", "F-150", 100.0, 2.5));
        vehicles.add(new Car("V007", "BMW", "X5", 120.0, 7));
        vehicles.add(new Truck("V008", "Mercedes", "Actros", 150.0, 10.0));
    }

    public void displayMenu() {
        System.out.println("\n=== Vehicle Rental System (OOP with Polymorphism) ===");
        System.out.println("1. Display Available Vehicles");
        System.out.println("2. Rent a Vehicle");
        System.out.println("3. Return a Vehicle");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void displayAvailableVehicles() {
        System.out.println("\n--- Available Vehicles ---");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles available at the moment.");
        }
    }

    public void rentVehicle() {
        System.out.println("\n--- Rent a Vehicle ---");
        displayAvailableVehicles();
        System.out.print("\nEnter Vehicle ID to rent: ");
        String vehicleId = scanner.nextLine();

        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is already rented!");
            return;
        }

        System.out.print("Enter number of days: ");
        int days;
        try {
            String daysInput = scanner.nextLine().trim();
            days = Integer.parseInt(daysInput);
            if (days <= 0) {
                System.out.println("Invalid number of days! Please enter a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return;
        }

        // Polymorphism: Method overloading - different calculateRentalCost methods
        System.out.print("Do you have a discount? (yes/no): ");
        String discountChoice = scanner.nextLine();
        
        double totalCost;
        if (discountChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage (0-100): ");
            double discountPercent;
            try {
                String discountInput = scanner.nextLine().trim();
                discountPercent = Double.parseDouble(discountInput);
                if (discountPercent < 0 || discountPercent > 100) {
                    System.out.println("Invalid discount! Using 0% discount.");
                    discountPercent = 0;
                }
                discountPercent = discountPercent / 100.0; // Convert to decimal
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Using 0% discount.");
                discountPercent = 0.0;
            }
            // Using overloaded method with discount
            totalCost = vehicle.calculateRentalCost(days, discountPercent);
        } else {
            // Using method without discount
            totalCost = vehicle.calculateRentalCost(days);
        }
        
        vehicle.setAvailable(false);

        System.out.println("\n✓ Vehicle rented successfully!");
        // Polymorphism: getVehicleType() is called - runtime decides which version to use
        System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + 
                          " (" + vehicle.getVehicleType() + ")");
        System.out.println("Days: " + days);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
    }

    public void returnVehicle() {
        System.out.println("\n--- Return a Vehicle ---");
        System.out.print("Enter Vehicle ID to return: ");
        String vehicleId = scanner.nextLine();

        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        if (vehicle.isAvailable()) {
            System.out.println("Vehicle is already available (not rented)!");
            return;
        }

        vehicle.setAvailable(true);
        System.out.println("\n✓ Vehicle returned successfully!");
        System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel() + " is now available.");
    }

    private Vehicle findVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void run() {
        int choice = 0;
        do {
            displayMenu();
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Please enter a valid option (1-4)!");
                    continue;
                }
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number (1-4).");
                choice = 0; // Set to invalid to continue loop
                continue;
            }

            switch (choice) {
                case 1:
                    displayAvailableVehicles();
                    break;
                case 2:
                    rentVehicle();
                    break;
                case 3:
                    returnVehicle();
                    break;
                case 4:
                    System.out.println("\nThank you for using Vehicle Rental System!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();
        system.run();
    }
}

