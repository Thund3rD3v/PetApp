import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What Do You Want To Name Your Pet?");

        Pet pet = new Pet(scanner.nextLine());
        Dashboard dashboard = new Dashboard(pet, scanner);

        dashboard.displayDashboard();


    }
}