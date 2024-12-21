public class Vehicle {
    private String brand;
    private String model;
    private long harga;
    private int stockQuantity;

    // Constructor
    public Vehicle(String brand, String model, long harga, int stockQuantity) {
        this.brand = brand;
        this.model = model;
        this.harga = harga;
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

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Harga: " + harga + ", Stock: " + stockQuantity;
    }
}
