import java.util.concurrent.*;

public class ParkingLot
{
    private Semaphore spots;
    private int carsServed;
    //private Logger logger;
    public ParkingLot()//Logger logger as a parameter
    {
        this.spots= new Semaphore(4);
        //this.logger = logger;
        this.carsServed=0;
    }

    public synchronized boolean tryToPark() {
        boolean returnValue = spots.tryAcquire();
        if (returnValue)
        {

            carsServed++;


            /*synchronized(this){
                spots.acquire();
                carsServed++;
                return true;
            }*/

        }
        return returnValue;

    }

    public synchronized void leaveSpot() {
        spots.release();
        //logger.logLeaving(car, getOccupiedSpots());
    }

    public int getPermits() {
        return spots.availablePermits();
    }

    public int getTotalCarsServed() {
        return carsServed;
    }
}