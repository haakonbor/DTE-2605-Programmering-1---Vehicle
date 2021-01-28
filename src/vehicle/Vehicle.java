package vehicle;

public abstract class Vehicle {
    private String colour, name, serialNumber;
    private int model, price, direction = 0;
    private double speed = 0;
    protected java.util.Scanner input = new java.util.Scanner(System.in);

    protected Vehicle() {
    }

    protected Vehicle(String colour, String name, String serialNumber, int model, int price, int direction) {
        this.colour = colour;
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
        this.direction = direction;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAllFields() {
        System.out.println("Name: ");
        this.name = input.nextLine();

        System.out.println("Colour: ");
        this.colour = input.nextLine();

        System.out.println("Price: ");
        this.price = input.nextInt();

        System.out.println("Model: ");
        this.model = input.nextInt();

        System.out.println("Serial #: ");
        this.serialNumber = input.nextLine();

        // Må bruke denne input-metoden, ellers vil den hoppe over inputen av serialNumber
        input.next();
    }

    public abstract void turnLeft(int degrees);

    public abstract void turnRight(int degrees);

    public String toString() {
        return "Colour: " + colour + "\n Name: " + name + "\n SerialNumber: " + serialNumber + "\n Model: " + model +
                "\n Price: " + price + "\n Direction: " + direction + "\n Speed: " + speed;
    }
}
