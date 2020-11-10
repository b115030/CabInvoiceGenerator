package com.bridgelabz.cabInvoiceGenerator;

import java.io.IOException;

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MIN_COST_PER_KILOMETER = 10.0;
    private static final double MIN_FARE = 5;
    private RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) throws InvoiceGeneratorException{
        try{
            double totalFare = distance*MIN_COST_PER_KILOMETER+time*COST_PER_TIME;
            return Math.max(totalFare, MIN_FARE);
        } catch (Exception exception){
            throw new InvoiceGeneratorException("Not the Correct data type", InvoiceGeneratorException.ExceptionType.NOT_ASSIGNED);
        }
    }

    public InvoiceSummary calculateFare(Ride[] rides ) throws InvoiceGeneratorException {
        double totalFare=0;
        try{
        for (Ride ride:rides) {
            totalFare+=this.calculateFare(ride.distance, ride.time);

        }
        } catch (NullPointerException nullPointerException){
            throw new InvoiceGeneratorException("The setup method hasn't initialized", InvoiceGeneratorException.ExceptionType.SETUP_METHOD_NOT_WORKING);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);;
    }

    public InvoiceSummary getInvoiceSummary(String userId) throws InvoiceGeneratorException {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
}
