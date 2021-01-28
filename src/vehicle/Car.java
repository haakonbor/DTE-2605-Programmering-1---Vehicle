package vehicle;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Car extends Vehicle {
    private int power;
    private Calendar productionDate;

    public Car() {
        productionDate = new GregorianCalendar();
    }

    public Car(String name, String colour, int price, int model, String serialNumber, int power, int direction) {
        super(colour, name, serialNumber, model, price, direction);
        this.power = power;
        productionDate = new GregorianCalendar();
    }

    @Override
    public Object clone() {
        Car carClone = (Car) super.clone();
        carClone.productionDate = (Calendar)productionDate.clone();
        return carClone;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Calendar getProductionDate () {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void setAllFields() {
        System.out.println("Input car data: ");
        super.setAllFields();
        System.out.println("Power: ");
        this.power = this.input.nextInt();
    }

    @Override
    public void turnLeft(int degrees) {
        if (degrees < 360 && degrees >= 0) {
            int newDirection = (getDirection() - degrees) % 360;
            if (newDirection < 0)
                newDirection = 360 + newDirection;
            setDirection(newDirection);
        }
    }

    @Override
    public void turnRight(int degrees) {
        if (degrees < 360 && degrees >= 0)  {
            int newDirection = (getDirection() + degrees) % 360;
            setDirection(newDirection);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nPower: " + power + "\nProduction date: " + productionDate.getTime() + "\n";
    }
}
