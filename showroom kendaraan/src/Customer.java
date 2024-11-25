public class Customer {
    private String name;
    private int totalPurchase;

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.totalPurchase = 0;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public int getTotalPurchase() {
        return totalPurchase;
    }

    // Buy vehicle and update total purchase
    public void buyVehicle(Vehicle vehicle, int quantity) {
        if (quantity <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari nol!");
            return;
        }
    
        if (vehicle.getStockQuantity() >= quantity) {
            vehicle.setStockQuantity(vehicle.getStockQuantity() - quantity);
            totalPurchase += vehicle.getPrice() * quantity;
            System.out.println(name + " membeli " + quantity + " unit " + vehicle.getModel() + ". Total: Rp" + (vehicle.getPrice() * quantity));
        } else {
            System.out.println("[Error] Stok tidak mencukupi untuk model: " + vehicle.getModel());
        }
    }

    @Override
    public String toString() {
        return "Nama: " + name + ", Total Pembelian: " + totalPurchase;
    }
}
