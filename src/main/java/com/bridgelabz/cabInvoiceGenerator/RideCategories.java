package com.bridgelabz.cabInvoiceGenerator;

public enum RideCategories {
    NORMAL(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20.0);

    private double costPerKm;
    private double costPerMin;
    private double minFarePerRide;

    RideCategories(double costPerKm, double costPerMin, double minFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFare;
    }
}
