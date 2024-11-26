import java.util.ArrayList;

public class kontrolmenu {
    
    public static void showMainMenu() {
        System.out.println("\n=== Menu Showroom ===");
        System.out.println("1. Lihat Daftar Kendaraan");
        System.out.println("2. Beli Kendaraan");
        System.out.println("3. Riwayat Transaksi");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void showViewVehiclesMenu() {
        System.out.println("\n-- Lihat Daftar Kendaraan --");
        System.out.println("1. Lihat Semua Kendaraan");
        System.out.println("2. Lihat Daftar Motor");
        System.out.println("3. Lihat Daftar Mobil");
        System.out.println("4. Cari Kendaraan");
        System.out.println("5. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static void showPurchaseMenu() {
        System.out.println("\n-- Beli Kendaraan --");
        System.out.println("1. Beli Motor");
        System.out.println("2. Beli Mobil");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static void showAllVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Semua Kendaraan --");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public static void showMotorcycles(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Motor --");
        for (Vehicle v : vehicles) {
            if (v instanceof Motorcycle) {
                System.out.println(v);
            }
        }
    }

    public static void showCars(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Mobil --");
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                System.out.println(v);
            }
        }
    }

    public static void searchVehicleByBrand(ArrayList<Vehicle> vehicles, String brand) {
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Kendaraan dengan merek tersebut tidak ditemukan.");
        }
    }

    public static void showVehiclesByType(ArrayList<Vehicle> vehicles, Class<?> vehicleType) {
        System.out.println("\n-- Daftar Kendaraan --");
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicleType.isInstance(vehicles.get(i))) {
                System.out.println((i + 1) + ". " + vehicles.get(i));
            }
        }
    }

    public static void showTransactionHistory(ArrayList<String> riwayatTransaksi, double totalPembelian) {
        System.out.println("\n-- Riwayat Transaksi --");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String transaksi : riwayatTransaksi) {
                System.out.println(transaksi);
            }
            System.out.println("Total Pembelian: Rp" + totalPembelian);
        }
    }
}
