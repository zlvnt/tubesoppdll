public class Customer {
    private String name;
    private double totalPurchase;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.totalPurchase = 0;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    // Add purchase amount to total
    public void addPurchase(double amount) {
        if (amount > 0) {
            this.totalPurchase += amount;
        } else {
            System.out.println("Jumlah pembelian harus lebih dari nol!");
        }
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", Total Pembelian: Rp" + totalPurchase;
    }
}