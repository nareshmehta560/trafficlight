public class Car {
    String carName;
    String whichLane;

    int enterTime;
    int exitTime;

    public Car(String carName,String whichLane, int enterTime) {
        this.carName = carName;
        this.whichLane = whichLane;
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return carName;
    }
}
