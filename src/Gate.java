public class Gate implements Runnable {
    private  ParkingLot parkingLot;
    private  int gateNumber;
    private int numberOfCars;
    private  int[] arrivalTimes;
    private  int[] parkingDurations;
    private  int[] carIds;

    public Gate(ParkingLot parkingLot, int gateNumber, int[] arrivalTimes, int[] parkingDurations) {
        this.parkingLot = parkingLot;
        this.gateNumber = gateNumber;
        this.arrivalTimes = arrivalTimes;
        this.parkingDurations = parkingDurations;
        numberOfCars = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < arrivalTimes.length; i++) {
            try {
                Thread.sleep(arrivalTimes[i] * 1000);
                Car car = new Car(gateNumber, parkingDurations[i], carIds[i],arrivalTimes[i], parkingLot);
                Thread carThread = new Thread(car);
                carThread.start();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars() {
        numberOfCars++;
    }
}