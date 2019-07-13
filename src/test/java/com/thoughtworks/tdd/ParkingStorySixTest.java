package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingStorySixTest {

    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(new ParkingBoy(parkingLots));
        Manager manager = new Manager(parkingBoys);
        Car car = new Car();
        Ticket ticket = manager.chooseParkingBoy(0).park(car);
        Car fetch = manager.chooseParkingBoy(0).fetch(ticket);

        Assertions.assertSame(car,fetch);
    }
}
