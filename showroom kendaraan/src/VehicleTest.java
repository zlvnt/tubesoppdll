import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            kontrolshowroom controller = new kontrolshowroom(scanner);
            controller.start();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan yang tidak terduga: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
