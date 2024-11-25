public class Car extends Vehicle {
    private String fuelType;
    private int seatingCapacity;

    // Constructor
    public Car(String brand, String model, int price, int stockQuantity, String fuelType, int seatingCapacity) {
        super(brand, model, price, stockQuantity);
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }

    // Getter and Setter
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        if (!fuelType.equalsIgnoreCase("Bensin") && !fuelType.equalsIgnoreCase("Diesel") && !fuelType.equalsIgnoreCase("Electric")) {
            System.out.println("Tipe bahan bakar tidak valid!");
        } else {
            this.fuelType = fuelType;
        }
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            System.out.println("Kapasitas tempat duduk harus lebih dari nol!");
        } else {
            this.seatingCapacity = seatingCapacity;
        }
    }

    // Override toString to include Car-specific attributes
    @Override
    public String toString() {
        return super.toString() + ", Fuel Type: " + fuelType + ", Seats: " + seatingCapacity;
    }
}
