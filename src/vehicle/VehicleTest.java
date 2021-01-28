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
      System.out.println("6..............................Exit program");
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
        //vis info om gitt kjøretøy
        break;
      case 4:
        //vis info om alle kjøretøy
        break;
      case 5:
        // Finn kjøretøy med gitt navn, sett ny retning
        break;
      case 6:
      	scan.close();
        System.exit(0);
      default:
        System.out.println("Wrong input!");
      }
    }
  }
}

