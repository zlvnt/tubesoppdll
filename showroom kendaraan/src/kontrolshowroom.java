import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class kontrolshowroom {

    private Scanner scanner;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<String> riwayatTransaksi;
    private ArrayList<String> detailInvoice;
    private double totalPembelian;
    private ArrayList<Customer> customers;

    private static final DecimalFormat df = new DecimalFormat("#,###.00");

    public kontrolshowroom(Scanner scanner) {
        this.scanner = scanner;
        this.vehicles = new ArrayList<>();
        this.riwayatTransaksi = new ArrayList<>();
        this.detailInvoice = new ArrayList<>(); 
        this.totalPembelian = 0;
        this.customers = new ArrayList<>();

        // Tambahkan kendaraan (contoh data)
        vehicles.add(new Car("Toyota", "Camry", 500000000, 3, "Bensin", 5));
        vehicles.add(new Car("Honda", "Civic", 400000000, 4, "Bensin", 5));
        vehicles.add(new Car("Mitsubishi", "Pajero Sport", 550000000, 3, "Diesel", 7));
        vehicles.add(new Car("Hyundai", "Ioniq 5", 850000000, 2, "Listrik", 5));
        vehicles.add(new Car("Suzuki", "Ertiga", 250000000, 5, "Bensin", 7));

        vehicles.add(new Motorcycle("Yamaha", "NMAX", 30000000, 7, 155, "Cruiser"));
        vehicles.add(new Motorcycle("Honda", "PCX 160", 32000000, 8, 160, "Scooter"));
        vehicles.add(new Motorcycle("Kawasaki", "Ninja 250", 64000000, 10, 250, "Sport"));
        vehicles.add(new Motorcycle("Suzuki", "GSX-S150", 30000000, 9, 150, "Street Bike"));
        vehicles.add(new Motorcycle("Vespa", "Primavera 150", 55000000, 7, 150, "Scooter"));
        // Tambahkan pelanggan (contoh data)
        customers.add(new Customer("John Doe"));
    }

    public void start() {
        int choice;
        do {
            kontrolmenu.MenuUtama();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    KontrolMenuKendaraan();
                    break;
                case 2:
                    KontrolMenuPembelianKendaraan();
                    break;
                case 3:
                    kontrolmenu.riwayatTransaksi(this, scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem showroom kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
    }

    private void KontrolMenuKendaraan() {
        int subChoice;
        do {
            kontrolmenu.MenuKendaraan();
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    kontrolmenu.LihatSemuaKendaraan(vehicles);
                    break;
                case 2:
                    kontrolmenu.LihatMotor(vehicles);
                    break;
                case 3:
                    kontrolmenu.LihatMobil(vehicles);
                    break;
                case 4:
                    System.out.print("\nMasukkan merek kendaraan: ");
                    scanner.nextLine();
                    String cariBrand = scanner.nextLine();
                    kontrolmenu.CariKendaraan(this, cariBrand);
                    break;
                case 5:
                    System.out.print("Harga minimum: ");
                    int minPrice = scanner.nextInt();
                    System.out.print("Harga maksimum: ");
                    int maxPrice = scanner.nextInt();
                
                    ArrayList<Vehicle> hasilFilter = kontrolFilterHarga(minPrice, maxPrice);
                
                    if (hasilFilter.isEmpty()) {
                        System.out.println("Tidak ada kendaraan dalam rentang harga tersebut.");
                    } else {
                        kontrolmenu.FilterHarga(hasilFilter);
                    }
                    break;
                case 6:
                    KontrolTambahKendaraan();
                    break;
                case 7:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (subChoice != 7);
    }

    public ArrayList<Vehicle> kontrolCariKendaraan(String brand) {
        ArrayList<Vehicle> hasil = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getBrand().equalsIgnoreCase(brand)) {
                hasil.add(v);
            }
        }
        return hasil;
    }    

    public ArrayList<Vehicle> kontrolFilterHarga(int minPrice, int maxPrice) {
        ArrayList<Vehicle> hasil = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getHarga() >= minPrice && v.getHarga() <= maxPrice) {
                hasil.add(v);
            }
        }
        return hasil;
    }
    
    private void KontrolMenuPembelianKendaraan() {
        int buyChoice;
        do {
            kontrolmenu.MenuPembelianKendaraan();
            buyChoice = scanner.nextInt();

            switch (buyChoice) {
                case 1:
                    kontrolRincianKendaraan(Motorcycle.class);
                    break;
                case 2:
                    kontrolRincianKendaraan(Car.class);
                    break;
                case 3:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (buyChoice != 3);
    }

    private void kontrolRincianKendaraan(Class<?> vehicleType) {
        if (vehicleType == Car.class) {
            kontrolmenu.LihatMobil(vehicles);
        } else if (vehicleType == Motorcycle.class) {
            kontrolmenu.LihatMotor(vehicles);
        }
    
        System.out.print("\nMasukkan nomor kendaraan yang ingin dibeli: ");
        int localIndex = scanner.nextInt();
        Vehicle selectedVehicle = null;
    
        int counter = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.isInstance(vehicle)) {
                if (counter == localIndex) {
                    selectedVehicle = vehicle;
                    break;
                }
                counter++;
            }
        }
    
        if (selectedVehicle == null) {
            System.out.println("Pilihan tidak valid. Harap masukkan nomor dari tabel.");
            return;
        }
    
        System.out.print("Masukkan jumlah unit: ");
        int quantity = scanner.nextInt();
    
        if (selectedVehicle.getStockQuantity() >= quantity) {
            double total = selectedVehicle.getHarga() * quantity;
    
            System.out.println("\n=== Rincian Harga ===");
            System.out.println("Harga per unit       : Rp" + df.format(selectedVehicle.getHarga()));
            System.out.println("Jumlah unit          : " + quantity);
            System.out.println("Total yang harus dibayar: Rp" + df.format(total));
            System.out.println("=====================");                      
    
            System.out.print("Masukkan nominal pembayaran: ");
            double nominalPembayaran = scanner.nextDouble();
    
            if (nominalPembayaran < total) {
                System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
                return;
            }
    
            double kembalian = nominalPembayaran - total;
    
            System.out.print("Masukkan nama pelanggan: ");
            scanner.nextLine(); // Clear buffer
            String customerName = scanner.nextLine();
            Customer customer = findCustomerByName(customerName);
    
            if (customer == null) {
                customer = new Customer(customerName);
                customers.add(customer);
            }
    
            selectedVehicle.setStockQuantity(selectedVehicle.getStockQuantity() - quantity);
            totalPembelian += total;
            riwayatTransaksi.add(selectedVehicle.getBrand() + " " + selectedVehicle.getModel() + " - " + quantity + " unit - Rp" + total);
            customer.addPurchase(total);
    
            System.out.println("Transaksi berhasil! Total: Rp" + total);
            System.out.println("Nominal pembayaran: Rp" + nominalPembayaran);
    
            if (kembalian > 0) {
                System.out.println("Kembalian: Rp" + kembalian);
            }
    
            generateInvoice(customer, selectedVehicle, quantity, total, nominalPembayaran, kembalian);
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }    
    
    private void generateInvoice(Customer customer, Vehicle vehicle, int quantity, double total, double nominalPembayaran, double kembalian) {
        String invoice = "\n========Invoice Pembelian========\n"
            + "Nama Pelanggan   : " + customer.getName() + "\n"
            + "Kendaraan        : " + vehicle.getBrand() + " " + vehicle.getModel() + "\n"
            + "Harga per Unit   : Rp" + df.format(vehicle.getHarga()) + "\n"
            + "Jumlah Unit      : " + quantity + "\n"
            + "Total Harga      : Rp" + df.format(total) + "\n"
            + "Nominal Dibayar  : Rp" + df.format(nominalPembayaran) + "\n"
            + "Kembalian        : Rp" + df.format(kembalian) + "\n"
            + "=================================";
        System.out.println(invoice);
        detailInvoice.add(invoice);
    }
    
    public void KontrolRiwayatTransaksi() {
        System.out.println("\n-- Riwayat Transaksi --");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
    
        for (int i = 0; i < riwayatTransaksi.size(); i++) {
            System.out.println((i + 1) + ". " + riwayatTransaksi.get(i));
        }
        System.out.println("Total Pembelian: Rp" + df.format(totalPembelian));
    }
    
    public String getDetailInvoice(int nomor) {
        if (nomor > 0 && nomor <= detailInvoice.size()) {
            return detailInvoice.get(nomor - 1);
        } else {
            return "Nomor riwayat tidak valid.";
        }
    }
    

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
    private void KontrolTambahKendaraan() {
        int tipe = kontrolmenu.MenuTambahKendaraan(scanner);
        scanner.nextLine();
    
        String brand = kontrolmenu.InputData(scanner, "merek");
        String model = kontrolmenu.InputData(scanner, "model");
        int harga = kontrolmenu.InputInteger(scanner, "harga");
        int stok = kontrolmenu.InputInteger(scanner, "stok");
        scanner.nextLine();
    
        if (tipe == 1) {
            String bahanBakar = kontrolmenu.InputData(scanner, "Tipe bahan bakar");
            int jumlahKursi = kontrolmenu.InputInteger(scanner, "jumlah kursi");
    
            vehicles.add(new Car(brand, model, harga, stok, bahanBakar, jumlahKursi));
            System.out.println("Mobil berhasil ditambahkan!");
        } else if (tipe == 2) {
            int ccMesin = kontrolmenu.InputInteger(scanner, "CC Mesin");
            scanner.nextLine(); // Clear buffer
            String kategori = kontrolmenu.InputData(scanner, "kategori");
    
            vehicles.add(new Motorcycle(brand, model, harga, stok, ccMesin, kategori));
            System.out.println("Motor berhasil ditambahkan!");
        } else {
            System.out.println("Pilihan tipe kendaraan tidak valid!");
        }
    }    
}
