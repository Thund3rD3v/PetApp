public class Pet {

    private String name;
    private int hunger = 0;
    private int steps = 0;

    public Pet(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getSteps() {
        return steps;
    }

    // Setters
    public void feed(int amount) {
        hunger-=amount;
    }

    public void addSteps(int amount) {
        steps+=amount;
        hunger+=amount/4;

    }

}
