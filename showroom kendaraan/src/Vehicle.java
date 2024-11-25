public class Vehicle {
    private String brand;
    private String model;
    private int price;
    private int stockQuantity;

    // Constructor
    public Vehicle(String brand, String model, int price, int stockQuantity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getter and Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Harga tidak boleh negatif!");
        } else {
            this.price = price;
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            System.out.println("Stok tidak boleh negatif!");
        } else {
            this.stockQuantity = stockQuantity;
        }
    }

    // Display basic vehicle information
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Price: " + price + ", Stock: " + stockQuantity;
    }
}
