package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingStoryFiveTest {
    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket_with_superSmartBoy(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(20));parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 15; i++) parkingBoy.park(new Car());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        Assertions.assertSame(9,parkingBoy.getParkingLots().get(1).getEmpty());
        Car fetch = parkingBoy.fetch(ticket);
        Assertions.assertSame(car,fetch);
        Assertions.assertSame(9,parkingBoy.getParkingLots().get(1).getEmpty());
    }
}
