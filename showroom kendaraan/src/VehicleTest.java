import java.util.ArrayList;
import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<String> riwayatTransaksi = new ArrayList<>();
        double totalPembelian = 0;

        // Tambahkan kendaraan (contoh data)
        vehicles.add(new Car("Toyota", "Camry", 500000000, 1, "Bensin", 5));
        vehicles.add(new Motorcycle("Yamaha", "NMAX", 30000000, 7, 155, "Cruiser"));

        int choice;

        do {
            // Tampilkan menu utama
            System.out.println("\n=== Menu Showroom ===");
            System.out.println("1. Lihat Daftar Kendaraan");
            System.out.println("2. Cari Kendaraan");
            System.out.println("3. Detail Kendaraan");
            System.out.println("4. Beli Kendaraan");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Lihat Daftar Kendaraan
                    System.out.println("\n-- Daftar Kendaraan --");
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println((i + 1) + ". " + vehicles.get(i));
                    }
                    break;

                case 2:
                    // Cari Kendaraan
                    System.out.print("\nMasukkan merek kendaraan: ");
                    scanner.nextLine(); // Clear buffer
                    String searchBrand = scanner.nextLine();
                    boolean found = false;
                    for (Vehicle v : vehicles) {
                        if (v.getBrand().equalsIgnoreCase(searchBrand)) { // Menggunakan getBrand()
                            System.out.println(v);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Kendaraan dengan merek tersebut tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Detail Kendaraan
                    System.out.print("\nMasukkan nomor kendaraan untuk detail: ");
                    int detailIndex = scanner.nextInt() - 1;
                    if (detailIndex >= 0 && detailIndex < vehicles.size()) {
                        System.out.println("\n-- Detail Kendaraan --");
                        System.out.println(vehicles.get(detailIndex));
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 4:
                    // Beli Kendaraan
                    System.out.print("\nMasukkan nomor kendaraan yang ingin dibeli: ");
                    int buyIndex = scanner.nextInt() - 1;
                    if (buyIndex >= 0 && buyIndex < vehicles.size()) {
                        System.out.print("Masukkan jumlah unit: ");
                        int quantity = scanner.nextInt();
                        Vehicle vehicle = vehicles.get(buyIndex);

                        if (vehicle.getStockQuantity() >= quantity) { // Menggunakan getStockQuantity()
                            vehicle.setStockQuantity(vehicle.getStockQuantity() - quantity); // Menggunakan setStockQuantity()
                            double total = vehicle.getPrice() * quantity; // Menggunakan getPrice()
                            totalPembelian += total;
                            riwayatTransaksi.add(vehicle.getBrand() + " " + vehicle.getModel() + " - " + quantity + " unit - Rp" + total);
                            System.out.println("Transaksi berhasil! Total: Rp" + total);
                        } else {
                            System.out.println("Stok tidak mencukupi!");
                        }
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 5:
                    // Riwayat Transaksi
                    System.out.println("\n-- Riwayat Transaksi --");
                    if (riwayatTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi.");
                    } else {
                        for (String transaksi : riwayatTransaksi) {
                            System.out.println(transaksi);
                        }
                        System.out.println("Total Pembelian: Rp" + totalPembelian);
                    }
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem showroom kami!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
