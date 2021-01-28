package vehicle;

public class Car extends Vehicle {
    private int power;

    public Car() {
    }

    public Car(String name, String colour, int price, int model, String serialNumber, int direction, int power) {
        super(colour, name, serialNumber, model, price, direction);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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
        return super.toString() + "\n Power: " + power;
    }
}
