package vehicle;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bicycle extends Vehicle {
    private int gears;
    private Calendar productionDate;

    public Bicycle() {
        productionDate = new GregorianCalendar();
    }

    public Bicycle(String name, String colour, int price, int model, String serialNumber, int gears, int direction) {
        super(colour, name, serialNumber, model, price, direction);
        this.gears = gears;
        productionDate = new GregorianCalendar();
    }

    @Override
    public Object clone() {
        Bicycle bicycleClone = (Bicycle) super.clone();
        bicycleClone.productionDate = (Calendar)productionDate.clone();
        return bicycleClone;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public Calendar getProductionDate () {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
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
        return super.toString() + "\nGears: " + gears + "\nProduction date: " + productionDate.getTime() + "\n";
    }

    @Override
    public void accelerate(int speedFactor) {
        double currentSpeed = getSpeed();
        double newSpeed;

        // Sykkelen står i ro
        if (currentSpeed == 0)
            newSpeed = 0.3 * speedFactor;

        // Sykkelen er i bevegelse
        else
            newSpeed = currentSpeed * 0.5 * speedFactor;

        // Velger den minste av den nye farten og max fart en sykkel kan ha
        setSpeed(Math.min(newSpeed, MAX_SPEED_BIKE));

        System.out.println("Vehicle accelerated to: " + getSpeed() + " km/h");
    }

    @Override
    public void breaks(int speedFactor) {
        setSpeed(getSpeed() / (speedFactor * 0.5));

        System.out.println("Vehicle slowed down to: " + getSpeed() + " km/h");
    }
}
