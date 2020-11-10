package com.bridgelabz.cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    Ride[] rides = null;
    InvoiceGenerator invoiceGenerator = null;
    InvoiceSummary expectedSummary = null;
    private RideRepository rideRepository = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        invoiceGenerator.setRideRepository(rideRepository);
        rides = new Ride[] {
                new Ride(RideCategories.NORMAL, 2.0, 5),
                new Ride(RideCategories.PREMIUM, 0.1, 1)
        };
        expectedSummary = new InvoiceSummary(2, 45);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() throws InvoiceGeneratorException {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() throws InvoiceGeneratorException {
        double distance = 0.1;
        int time = 1;
        double fare = 0;
        fare = invoiceGenerator.calculateFare(distance, time);
        System.out.println(fare);
        Assert.assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException {
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() throws InvoiceGeneratorException {
        String userId = "doodle";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenWrongDataTypeEntry_ShouldThrowException() {
        try {
            double distance = 2.0;
            char time = 'd';
            invoiceGenerator.calculateFare(distance, time);
        }catch (InvoiceGeneratorException invoiceGeneratorException){
            Assert.assertEquals("Not the Correct data type", invoiceGeneratorException.getMessage());
        }
    }
    @Test
    public void name() {
        rides=null;
        try {
            invoiceGenerator.calculateFare(rides);
            new InvoiceSummary(2, 30.0);
        }catch (InvoiceGeneratorException invoiceGeneratorException){
            Assert.assertEquals("The setup method hasn't initialized", invoiceGeneratorException.getMessage());
        }
    }
}
