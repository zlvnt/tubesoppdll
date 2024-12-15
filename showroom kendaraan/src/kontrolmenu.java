import java.util.ArrayList;
import java.util.Scanner;

public class kontrolmenu {
    
    public static void MenuUtama() {
        System.out.println("\n=== Menu Showroom ===");
        System.out.println("1. Lihat Daftar Kendaraan");
        System.out.println("2. Beli Kendaraan");
        System.out.println("3. Riwayat Transaksi");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void MenuKendaraan() {
        System.out.println("\n-- Lihat Daftar Kendaraan --");
        System.out.println("1. Lihat Semua Kendaraan"); 
        System.out.println("2. Lihat Daftar Motor");
        System.out.println("3. Lihat Daftar Mobil");
        System.out.println("4. Cari Kendaraan");
        System.out.println("5. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static void MenuPembelianKendaraan() {
        System.out.println("\n-- Beli Kendaraan --");
        System.out.println("1. Beli Motor");
        System.out.println("2. Beli Mobil");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static void LihatSemuaKendaraan(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Semua Kendaraan --");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public static void LihatMotor(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Motor --");
        for (Vehicle v : vehicles) {
            if (v instanceof Motorcycle) {
                System.out.println(v);
            }
        }
    }

    public static void LihatMobil(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Mobil --");
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                System.out.println(v);
            }
        }
    }

    public static void CariMerekKendaraan(ArrayList<Vehicle> vehicles, String brand) {
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

    public static void RincianKendaraan(ArrayList<Vehicle> vehicles, Class<?> vehicleType) {
        System.out.println("\n-- Daftar Kendaraan --");
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicleType.isInstance(vehicles.get(i))) {
                System.out.println((i + 1) + ". " + vehicles.get(i));
            }
        }
    }

    public static void riwayatTransaksi(ArrayList<String> riwayatTransaksi, ArrayList<String> detailInvoice, double totalPembelian, Scanner scanner) {
        System.out.println("\n-- Riwayat Transaksi --");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (int i = 0; i < riwayatTransaksi.size(); i++) {
                System.out.println((i + 1) + ". " + riwayatTransaksi.get(i));
            }
            System.out.println("Total Pembelian: Rp" + totalPembelian);

            System.out.println("\nLihat detail pembelian? (yes/no): ");
            String pilihan = scanner.next();

            if (pilihan.equalsIgnoreCase("yes")) {
                System.out.print("Masukkan nomor riwayat: ");
                int nomor = scanner.nextInt();
                if (nomor > 0 && nomor <= detailInvoice.size()) {
                    System.out.println(detailInvoice.get(nomor - 1));
                } else {
                    System.out.println("Nomor riwayat tidak valid.");
                }
            } else if (pilihan.equalsIgnoreCase("no")) {
                System.out.println("Kembali ke menu utama.");
            } else {
                System.out.println("Pilihan tidak valid. Kembali ke menu utama.");
            }
        }
    }
}
