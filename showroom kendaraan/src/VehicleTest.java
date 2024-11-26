import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        kontrolshowroom controller = new kontrolshowroom(scanner);
        controller.start();
        scanner.close();
    }
}