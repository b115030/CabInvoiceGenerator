package bl.CabInvoiceGenerator;

public class Ride {
    public double distance;
    public int time;
    public final RideCategories rideCategories;
    public Ride(RideCategories rideCategories, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideCategories = rideCategories;
    }
}
