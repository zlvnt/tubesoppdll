public class Motorcycle extends Vehicle {
    private int engineCC;
    private String category;

    // Constructor
    public Motorcycle(String brand, String model, int price, int stockQuantity, int engineCC, String category) {
        super(brand, model, price, stockQuantity);
        this.engineCC = engineCC;
        this.category = category;
    }

    // Getter and Setter
    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        if (engineCC <= 0) {
            System.out.println("Kapasitas mesin harus lebih dari nol!");
        } else {
            this.engineCC = engineCC;
        }
    }

    public String getCategory() {
        return category;
    }

public void setCategory(String category) {
    if (!category.equalsIgnoreCase("Sport") && !category.equalsIgnoreCase("Cruiser") && !category.equalsIgnoreCase("Adventure")) {
        System.out.println("Kategori motor tidak valid!");
    } else {
        this.category = category;
    }
}

    // Override toString to include Motorcycle-specific attributes
    @Override
    public String toString() {
        return super.toString() + ", Engine CC: " + engineCC + ", Category: " + category;
    }
}
