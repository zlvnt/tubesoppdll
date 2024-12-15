public class Car extends Vehicle {
    private String tipebb;
    private int kapasitasduduk;

    // Constructor
    public Car(String brand, String model, int harga, int stockQuantity, String tipebb, int kapasitasduduk) {
        super(brand, model, harga, stockQuantity);
        this.tipebb = tipebb;
        this.kapasitasduduk = kapasitasduduk;
    }

    // Getter and Setter
    public String getTipebb() {
        return tipebb;
    }

    public int getKapasitasDuduk() {
        return kapasitasduduk;
    }

    // Override toString to include Car-specific attributes
    @Override
    public String toString() {
        return super.toString() + ", Bahan Bakar: " + tipebb + ", Jumlah Kursi: " + kapasitasduduk;
    }
}
