import java.util.ArrayList;
import java.util.Scanner;

public class kontrolshowroom {

    private Scanner scanner;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<String> riwayatTransaksi;
    private ArrayList<String> detailInvoice;
    private double totalPembelian;
    private ArrayList<Customer> customers;

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
                    KontrolRiwayatTransaksi();
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
                    scanner.nextLine(); // Clear buffer
                    String searchBrand = scanner.nextLine();
                    kontrolmenu.CariMerekKendaraan(vehicles, searchBrand);
                    break;
                case 5:
                    System.out.println("Kembali ke Menu Utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (subChoice != 5);
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
        kontrolmenu.RincianKendaraan(vehicles, vehicleType);
        System.out.print("\nMasukkan nomor kendaraan yang ingin dibeli: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < vehicles.size() && vehicleType.isInstance(vehicles.get(index))) {
            System.out.print("Masukkan jumlah unit: ");
            int quantity = scanner.nextInt();
            Vehicle vehicle = vehicles.get(index);

            double total = vehicle.getHarga() * quantity;
            System.out.println("Total yang harus dibayar: Rp" + total);

            if (vehicle.getStockQuantity() >= quantity) {
                System.out.print("Masukkan nominal pembayaran: ");
                double nominalPembayaran = scanner.nextDouble();
    
                if (nominalPembayaran < total) {
                    System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
                    return;
                }
                
                if (nominalPembayaran < total) {
                    System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
                    return;
                }

                double kembalian = nominalPembayaran - total;
                System.out.print("Masukkan nama pelanggan: ");
                scanner.nextLine(); 
                String customerName = scanner.nextLine();
                Customer customer = findCustomerByName(customerName);

                if (customer == null) {
                    customer = new Customer(customerName);
                    customers.add(customer);
                }

                vehicle.setStockQuantity(vehicle.getStockQuantity() - quantity);
                totalPembelian += total;
                riwayatTransaksi.add(vehicle.getBrand() + " " + vehicle.getModel() + " - " + quantity + " unit - Rp" + total);
                customer.addPurchase(total);

                System.out.println("Transaksi berhasil! Total: Rp" + total);
                System.out.println("Nominal pembayaran: Rp" + nominalPembayaran);

                if (kembalian > 0) {
                    System.out.println("Kembalian: Rp" + kembalian);
                }

                generateInvoice(customer, vehicle, quantity, total, nominalPembayaran, kembalian);
            } else {
                System.out.println("Stok tidak mencukupi!");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private void generateInvoice(Customer customer, Vehicle vehicle, int quantity, double total, double nominalPembayaran, double kembalian) {
        String invoice = "\n========Invoice Pembelian========\n"
        + "Nama Pelanggan   : " + customer.getName() + "\n"
        + "Kendaraan        : " + vehicle.getBrand() + " " + vehicle.getModel() + "\n"
        + "Harga per Unit   : Rp" + vehicle.getHarga() + "\n"
        + "Jumlah Unit      : " + quantity + "\n"
        + "Total Harga      : Rp" + total + "\n"
        + "Nominal Dibayar  : Rp" + nominalPembayaran + "\n"
        + "Kembalian        : Rp" + kembalian + "\n"
        + "=================================";
        System.out.println(invoice);
        detailInvoice.add(invoice);
    }
    private void KontrolRiwayatTransaksi() {
        kontrolmenu.riwayatTransaksi(riwayatTransaksi, detailInvoice,totalPembelian, scanner);
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
