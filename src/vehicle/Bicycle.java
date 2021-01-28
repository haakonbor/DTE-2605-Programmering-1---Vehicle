package vehicle;

public class Bicycle extends Vehicle {
    private int gears;

    public Bicycle() {
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int direction, int gears) {
        super(colour, name, serialNumber, model, price, direction);
        this.gears = gears;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public void setAllFields() {
        super.setAllFields();
        System.out.println("Gears: ");
        this.gears = this.input.nextInt();
    }

    @Override
    public void turnLeft(int degrees) {
        System.out.println("Turned " + degrees + " degrees left.\n");
    }

    @Override
    public void turnRight(int degrees) {
        System.out.println("Turned " + degrees + " degrees right.\n");
    }

    @Override
    public String toString() {
        return super.toString() + "\n Gears: " + gears;
    }
}
