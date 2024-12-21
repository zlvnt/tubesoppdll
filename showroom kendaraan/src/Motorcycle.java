
public class Motorcycle extends Vehicle {
    private int ccMESIN;
    private String kategori;

    // Constructor
    public Motorcycle(String brand, String model, int harga, int stockQuantity, int ccMESIN, String kategori) {
        super(brand, model, harga, stockQuantity);
        this.ccMESIN = ccMESIN;
        this.kategori = kategori;
    }

    // Getter and Setter
    public int getCCMesin() {
        return ccMESIN;
    }

    public String getkategori() {
        return kategori;
    }

    @Override
    public String toString() {
        return super.toString() + ", CC Mesin: " + ccMESIN + ", Kategori: " + kategori;
    }
}
