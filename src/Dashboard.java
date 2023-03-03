import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Dashboard {

    Random r = new Random();
    private Pet pet;
    private Scanner scanner;

    public Dashboard(Pet pet, Scanner scanner) {
        this.pet = pet;
        this.scanner = scanner;
    }


    private int feedPet() {
        int hunger = pet.getHunger();
        if (hunger == 0) {
            return 0;
        }
        if (hunger < 5) {
            pet.feed(hunger);
            return 1;
        }
        pet.feed(5);
        return 1;
    }

    private void displayOptions() throws IOException, InterruptedException {
        // Options
        System.out.println("\nPick Option");
        System.out.println("A. Take Pet For A Walk");
        System.out.println("B. Feed Pet");

        String option = scanner.nextLine();

        // If Option A is selected
        if (option.toLowerCase().equals("a")) {
            if (pet.getHunger() >= 100) {
                System.out.println("Feed your pet he is starving!");
                System.out.println("Press enter to continue");

                // Wait for key press to continue
                scanner.nextLine();

                this.displayOptions();

            } else {
                int steps = r.nextInt(100, 200);

                pet.addSteps(steps);

                System.out.println("Took " + steps + " steps for " + steps/4 + " hunger");
                System.out.println("Press enter to continue");

                // Wait for key press to continue
                scanner.nextLine();

                this.displayDashboard();
            }
        } else if (option.toLowerCase().equals("b")) {

            int feedingResponse = feedPet();

            // If food is fed
            if (feedingResponse == 1) {

                System.out.println("Done feeding!");
                System.out.println("Press enter to continue");

                // Wait for key press to continue
                scanner.nextLine();

                displayDashboard();
            } else {
                System.out.println("Sorry, your pet is full.");

                System.out.println("Press enter to continue");

                // Wait for key press to continue
                scanner.nextLine();

                this.displayOptions();
            }

        } else {
            System.out.println("Please Pick Option A or B");
            displayOptions();
        }

    }

    public void displayDashboard() throws IOException, InterruptedException {

        // Clear console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        // Name of pet
        System.out.println(pet.getName());

        // The line below the name
        System.out.println("-".repeat(pet.getName().length()+4));

        // Hunger %
        System.out.println("Hunger: "+ + pet.getHunger() + "%");

        // Steps
        System.out.println("Steps: " + pet.getSteps());

        displayOptions();
    }
}
