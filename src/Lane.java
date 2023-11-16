import java.text.DecimalFormat;
import java.util.*;

public class Lane {
    String laneName;
    LinkedList<Car> cars = new LinkedList<>();
    LinkedList<Car> exitedCars = new LinkedList<>();
    double probablityToAdd;
    Random random = new Random();
    int totalCar = 0;
    int carNumber = 0;


    // Constructor
    public Lane(String laneName,double probablity) {
        this.laneName = laneName;
        this.probablityToAdd = probablity;
    }



    public LinkedList<Car> getCars() {
        return cars;
    }
    public void addCar(String laneName, int time) {
            cars.addLast(new Car("carfromA3" + carNumber++,laneName, time));
            totalCar++;
    }
    public boolean addOrNot() {
        double generatedProbablity = random.nextDouble();
        if (generatedProbablity < this.probablityToAdd) {
            System.out.print("Probability at " + laneName + ": " + new DecimalFormat("#.#####").format(generatedProbablity) + " < " + this.probablityToAdd);
            return true;
        } else {
            System.out.print("Probability at " + laneName + ": " + new DecimalFormat("#.#####").format(generatedProbablity) + " < " + this.probablityToAdd);
            return false;
        }
    }

    public void addCar(int time) {
        if (addOrNot()){
            cars.add(new Car("car" + carNumber++,this.laneName, time));
            totalCar++;
            System.out.print(" Yes");
        }
        System.out.println();

    }

    public void addCar(Car car) {
        cars.add(car);
    }
    public boolean removeCar(int time) {
        double generatedProbablity = random.nextDouble();
        if(cars.isEmpty()){
            System.out.println(laneName.substring(0,2) + " Empty");
            return false;
        }
        else if (generatedProbablity < 0.50) {
            Car toDelete = cars.poll();
            if(!toDelete.carName.equals("Empty")){
                toDelete.exitTime = time;
                exitedCars.add(toDelete);
                System.out.println(laneName + " REMOVED " + toDelete);
                System.out.println(laneName + " EXITED CARS LIST : " + exitedCars);
                System.out.println(laneName + " DWELL TIME FOR " + toDelete.carName + " : " + toDelete.exitTime + "-" + toDelete.enterTime);
                this.totalCar--;
            }
            return true;
        } else {
            System.out.println(laneName + " Remove Probability False");
            return false;
        }
    }

}
