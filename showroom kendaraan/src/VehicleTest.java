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
            System.out.println("2. Beli Kendaraan");
            System.out.println("3. Riwayat Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
        
            switch (choice) {
                case 1:
                    int subChoice;
                    do {
                        // Tampilkan sub-menu Lihat Daftar Kendaraan
                        System.out.println("\n-- Lihat Daftar Kendaraan --");
                        System.out.println("1. Lihat Semua Kendaraan");
                        System.out.println("2. Lihat Daftar Motor");
                        System.out.println("3. Lihat Daftar Mobil");
                        System.out.println("4. Cari Kendaraan");
                        System.out.println("5. Kembali ke Menu Utama");
                        System.out.print("Pilih opsi: ");
                        subChoice = scanner.nextInt();
        
                        switch (subChoice) {
                            case 1:
                                System.out.println("\n-- Semua Kendaraan --");
                                for (int i = 0; i < vehicles.size(); i++) {
                                    System.out.println((i + 1) + ". " + vehicles.get(i));
                                }
                                break;
                            case 2:
                                System.out.println("\n-- Daftar Motor --");
                                for (Vehicle v : vehicles) {
                                    if (v instanceof Motorcycle) {
                                        System.out.println(v);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("\n-- Daftar Mobil --");
                                for (Vehicle v : vehicles) {
                                    if (v instanceof Car) {
                                        System.out.println(v);
                                    }
                                }
                                break;
                            case 4:
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
                            case 5:
                                System.out.println("Kembali ke Menu Utama.");
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    } while (subChoice != 5);
                    break;
        
                case 2:
                int buyChoice;
                do {
                    // Tampilkan sub-menu Beli Kendaraan
                    System.out.println("\n-- Beli Kendaraan --");
                    System.out.println("1. Beli Motor");
                    System.out.println("2. Beli Mobil");
                    System.out.println("3. Kembali ke Menu Utama");
                    System.out.print("Pilih opsi: ");
                    buyChoice = scanner.nextInt();
    
                    switch (buyChoice) {
                        case 1:
                            System.out.println("\n-- Daftar Motor --");
                            for (int i = 0; i < vehicles.size(); i++) {
                                if (vehicles.get(i) instanceof Motorcycle) {
                                    System.out.println((i + 1) + ". " + vehicles.get(i));
                                }
                            }
                            System.out.print("\nMasukkan nomor motor yang ingin dibeli: ");
                            int motorIndex = scanner.nextInt() - 1;
                            if (motorIndex >= 0 && motorIndex < vehicles.size() && vehicles.get(motorIndex) instanceof Motorcycle) {
                                System.out.print("Masukkan jumlah unit: ");
                                int quantity = scanner.nextInt();
                                Vehicle vehicle = vehicles.get(motorIndex);
    
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
                        case 2:
                            System.out.println("\n-- Daftar Mobil --");
                            for (int i = 0; i < vehicles.size(); i++) {
                                if (vehicles.get(i) instanceof Car) {
                                    System.out.println((i + 1) + ". " + vehicles.get(i));
                                }
                            }
                            System.out.print("\nMasukkan nomor mobil yang ingin dibeli: ");
                            int carIndex = scanner.nextInt() - 1;
                            if (carIndex >= 0 && carIndex < vehicles.size() && vehicles.get(carIndex) instanceof Car) {
                                System.out.print("Masukkan jumlah unit: ");
                                int quantity = scanner.nextInt();
                                Vehicle vehicle = vehicles.get(carIndex);
    
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
                        case 3:
                            System.out.println("Kembali ke Menu Utama.");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } while (buyChoice != 3);
                break;

                case 3:
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
        
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem showroom kami!");
                    break;
        
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
        
        scanner.close();
        
    }
}
