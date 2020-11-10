package com.bridgelabz.cabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> rideMap = null;

    public RideRepository() {
        rideMap = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.rideMap.get(userId);
        if (rideList == null) {
            rideList = new ArrayList<>(Arrays.asList(rides));
            this.rideMap.put(userId, rideList);
        }
    }

    public Ride[] getRides(String userId) {
        return this.rideMap.get(userId).toArray(new Ride[0]);
    }
}