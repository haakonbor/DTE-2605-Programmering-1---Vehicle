package vehicle;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Vehicle implements Comparable<Vehicle>, Cloneable {
    private String colour, name, serialNumber;
    private int model, price, direction = 0;
    private double speed = 0;
    private Calendar buyingDate;
    protected java.util.Scanner input = new java.util.Scanner(System.in);

    protected Vehicle() {
        this.buyingDate = new GregorianCalendar();
    }

    protected Vehicle(String colour, String name, String serialNumber, int model, int price, int direction) {
        this.colour = colour;
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
        this.direction = direction;
        this.buyingDate = new GregorianCalendar();
    }

    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(getPrice(), o.getPrice());
    }

    @Override
    public Object clone() {
        try {
            Vehicle vehicleClone = (Vehicle)super.clone();
            vehicleClone.buyingDate = (Calendar)buyingDate.clone();
            return vehicleClone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
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

    public String getBuyingDate() {
        return buyingDate.getTime().toString();
    }

    public void setBuyingDate(Calendar buyingDate) {
        this.buyingDate = buyingDate;
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

        // Må bruke denne input-metoden, ellers vil den hoppe over inputen av serialNumber
        input.nextLine();

        System.out.println("Serial #: ");
        this.serialNumber = input.nextLine();
    }

    public abstract void turnLeft(int degrees);

    public abstract void turnRight(int degrees);

    public String toString() {
        return "Name: " + name + "\nColour: " + colour + "\nSerialNumber: " + serialNumber + "\nModel: " + model +
                "\nPrice: " + price + "\nDirection: " + direction +
                "\nSpeed: " + speed + "\nBuying date: " + buyingDate.getTime();
    }
}
