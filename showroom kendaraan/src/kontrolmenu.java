import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class kontrolmenu {
    
    private static final DecimalFormat df = new DecimalFormat("#,###.00");

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
        System.out.println("4. Cari Merek Kendaraan");
        System.out.println("5. Filter Kendaraan Berdasarkan Harga");
        System.out.println("6. Tambah Kendaraan");
        System.out.println("7. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static void MenuPembelianKendaraan() {
        System.out.println("\n-- Beli Kendaraan --");
        System.out.println("1. Beli Motor");
        System.out.println("2. Beli Mobil");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.print("Pilih opsi: ");
    }

    public static int MenuTambahKendaraan(Scanner scanner) {
        System.out.println("\n-- Tambah Kendaraan --");
        System.out.println("Pilih tipe kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Masukkan pilihan: ");
        return scanner.nextInt();
    }

    public static void TambahKendaraan(Scanner scanner, ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Tambah Kendaraan --");
        System.out.print("Pilih tipe kendaraan (1: Mobil, 2: Motor): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();
    
        String brand = InputData(scanner, "merek");
        String model = InputData(scanner, "model");
        long harga = InputInteger(scanner, "harga");
        int stok = InputInteger(scanner, "stok");
        scanner.nextLine();

    if (tipe == 1) {
        String bahanBakar = InputData(scanner, "Tipe bahan bakar");
        int jumlahKursi = InputInteger(scanner, "jumlah kursi");
        vehicles.add(Vehicle.buatKendaraan("Car", brand, model, harga, stok, bahanBakar, jumlahKursi));
        System.out.println("Mobil berhasil ditambahkan!");
    } else if (tipe == 2) {
        int ccMesin = InputInteger(scanner, "CC Mesin");
        scanner.nextLine(); // Membersihkan buffer
        String kategori = InputData(scanner, "kategori");
        vehicles.add(Vehicle.buatKendaraan("Motorcycle", brand, model, harga, stok, kategori, ccMesin));
        System.out.println("Motor berhasil ditambahkan!");
    } else {
        System.out.println("Pilihan tidak valid!");
    }

    }  
    
    public static void LihatSemuaKendaraan(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Semua Kendaraan --");
        LihatMobil(vehicles);
        LihatMotor(vehicles);
    }

    public static void LihatMotor(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Motor --");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-15s %-10s\n",
            "No", "Brand", "Model", "Harga", "Stock", "CC Mesin", "Kategori");
        System.out.println("---------------------------------------------------------------------------------------------");
    
        int localIndex = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                Motorcycle motor = (Motorcycle) vehicle;
                System.out.printf("%-5d %-15s %-15s Rp%-15s %-10d %-15d %-10s\n",
                    localIndex++, motor.getBrand(), motor.getModel(), df.format(motor.getHarga()),
                    motor.getStockQuantity(), motor.getCCMesin(), motor.getkategori());
            }
        }
    }
    
    public static void LihatMobil(ArrayList<Vehicle> vehicles) {
        System.out.println("\n-- Daftar Mobil --");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-15s %-10s\n",
            "No", "Brand", "Model", "Harga", "Stock", "Bahan Bakar", "Jumlah Kursi");
        System.out.println("---------------------------------------------------------------------------------------------");
    
        int localIndex = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car mobil = (Car) vehicle;
                System.out.printf("%-5d %-15s %-15s Rp%-15s %-10d %-15s %-10d\n",
                    localIndex++, mobil.getBrand(), mobil.getModel(), df.format(mobil.getHarga()),
                    mobil.getStockQuantity(), mobil.getTipebb(), mobil.getKapasitasDuduk());
            }
        }
    }
      
    public static void CariKendaraan(kontrolshowroom showroom, String brand) {
        ArrayList<Vehicle> hasil = showroom.kontrolCariKendaraan(brand);
        if (hasil.isEmpty()) {
            System.out.println("Kendaraan dengan merek tersebut tidak ditemukan.");
        } else {
            System.out.printf("%-5s %-15s %-15s %-15s %-10s\n", 
                "No", "Brand", "Model", "Harga", "Stock");
            System.out.println("----------------------------------------------------");
    
            int localIndex = 1;
            for (Vehicle v : hasil) {
                System.out.printf("%-5d %-15s %-15s Rp%-15s %-10d\n", 
                    localIndex++, v.getBrand(), v.getModel(), df.format(v.getHarga()), v.getStockQuantity());
            }
        }
    }
    
    public static void FilterHarga(ArrayList<Vehicle> hasil) {
        System.out.printf("%-5s %-15s %-15s %-15s %-10s\n",
            "No", "Brand", "Model", "Harga", "Stock");
        System.out.println("----------------------------------------------------");
    
        int localIndex = 1;
        for (Vehicle v : hasil) {
            System.out.printf("%-5d %-15s %-15s Rp%-15s %-10d\n",
                localIndex++, v.getBrand(), v.getModel(), df.format(v.getHarga()), v.getStockQuantity());
        }
    }
    
    public static void riwayatTransaksi(kontrolshowroom showroom, Scanner scanner) {
        showroom.KontrolRiwayatTransaksi();
    
        System.out.println("\nLihat detail pembelian? (yes/no): ");
        String pilihan = scanner.next();
    
        if (pilihan.equalsIgnoreCase("yes")) {
            System.out.print("Masukkan nomor riwayat: ");
            if (scanner.hasNextInt()) {
                int nomor = scanner.nextInt();
    
                String invoiceDetail = showroom.getDetailInvoice(nomor);
                System.out.println(invoiceDetail);
            } else {
                System.out.println("Input tidak valid. Masukkan nomor riwayat berupa angka.");
                scanner.next();
            }
        } else if (!pilihan.equalsIgnoreCase("no")) {
            System.out.println("Pilihan tidak valid. Kembali ke menu utama.");
        }
    }

    public static String InputData(Scanner scanner, String label) {
        System.out.print("Masukkan " + label + ": ");
        return scanner.nextLine();
    }
    
    public static int InputInteger(Scanner scanner, String label) {
        System.out.print("Masukkan " + label + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus berupa angka. Silakan coba lagi.");
            scanner.next();
        }
        return scanner.nextInt();
    }   
}
