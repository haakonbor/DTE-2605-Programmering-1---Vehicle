package vehicle;

/**
 * TestVehicles oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 */

import java.util.*;
import java.io.*;

public class VehicleTest {
    public static void main(String[] args) {
        VehicleTest vtest = new VehicleTest();
        try {
            vtest.menuLoop();
        } catch(IOException e) {
            System.out.println("IO Exception!");
            System.exit(1);
        } catch(CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
            System.exit(1);
        }
    }

    private void menuLoop() throws IOException, CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
        Vehicle vehicle;

        arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
        arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
        arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
        arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));

        while(true) {
            System.out.println("1...................................New car");
            System.out.println("2...............................New bicycle");
            System.out.println("3......................Find vehicle by name");
            System.out.println("4..............Show data about all vehicles");
            System.out.println("5.......Change direction of a given vehicle");
            System.out.println("6.........................Test clone method");
            System.out.println("7..................Test driveable interface");
            System.out.println("8..............................Exit program");
            System.out.println(".............................Your choice?");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Car car = new Car();
                    car.setAllFields();
                    arr.add(car);
                    break;
                case 2:
                    Bicycle bicycle = new Bicycle();
                    bicycle.setAllFields();
                    arr.add(bicycle);
                    break;
                case 3:
                    System.out.println("Name of vehicle: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    boolean found = false;

                    for (Vehicle i : arr) {
                        if (i.getName().equals(name)) {
                            System.out.println(i);
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Vehicle \"" + name + "\" not found.");

                    break;
                case 4:
                    for (Vehicle i : arr) {
                        System.out.println(i);
                    }
                    break;
                case 5:
                    System.out.println("Name of vehicle: ");
                    scan.nextLine();
                    name = scan.nextLine();
                    found = false;

                    for (Vehicle i : arr) {
                        if (i.getName().equals(name)) {
                            found = true;

                            System.out.println("Direction [R/L]: ");
                            String direction = scan.nextLine();

                            if (!(direction.equals("L") || direction.equals("R"))) {
                                System.out.println("Invalid direction.");
                                break;
                            }

                            System.out.println("Degrees [0 - 360]: ");
                            int degrees = scan.nextInt();

                            if (direction.equals("L"))
                                i.turnLeft(degrees);

                            else
                                i.turnRight(degrees);

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Vehicle \"" + name + "\" not found.");
                        break;
                    }

                    break;
                case 6:
                    Car originalCar = new Car("Test", "blue", 200000, 2005, "12345", 300, 0);
                    Car cloneCar = (Car)originalCar.clone();

                    Calendar buyTest = new GregorianCalendar(2025, Calendar.JUNE, 15);
                    Calendar productionTest = new GregorianCalendar(2005, Calendar.FEBRUARY, 28);
                    originalCar.setBuyingDate(buyTest);
                    originalCar.setProductionDate(productionTest);

                    System.out.println("Original:\n" + originalCar + "\nCopy:\n" + cloneCar);
                    break;
                case 7:
                    Car testCar = new Car();
                    Bicycle testBicycle = new Bicycle();

                    System.out.println("Car:");
                    testCar.accelerate(5);
                    testCar.accelerate(25);
                    testCar.breaks(10);
                    testCar.stop();

                    System.out.println("\nBicycle:");
                    testBicycle.accelerate(4);
                    testBicycle.accelerate(20);
                    testBicycle.breaks(9);
                    testBicycle.stop();
                    System.out.println("\n");
                    break;
                case 8:
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}

