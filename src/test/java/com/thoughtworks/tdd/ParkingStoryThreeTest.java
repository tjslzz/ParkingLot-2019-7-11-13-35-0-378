package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingStoryThreeTest {
    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket_with_number_11_Cars(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) parkingBoy.park(new Car());
        Car car11 = new Car();
        Ticket ticket = parkingBoy.park(car11);
        Car fetch = parkingBoy.fetch(ticket);

        Assertions.assertSame(car11,fetch);
    }
}
