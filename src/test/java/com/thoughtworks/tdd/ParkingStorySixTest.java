package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingStorySixTest {

    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket_on_manager_choose_parkingBoy(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        List<ParkingBoy> ParkingBoys = new ArrayList<>();
        ParkingBoys.add(new BasicParkingBoy(parkingLots));
        ParkingBoys.add(new SmartParkingBoy(parkingLots));
        ParkingBoys.add(new SuperSmartParkingBoy(parkingLots));
        Manager manager = new Manager(parkingLots, ParkingBoys);
        Car car = new Car();
        Ticket ticket = manager.chooseParkingBoy(0).park(car);
        Car fetch = manager.chooseParkingBoy(0).fetch(ticket);

        Assertions.assertSame(car,fetch);
    }

    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket_on_manager(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        Manager manager = new Manager(parkingLots,new ArrayList<>());
        Car car = new Car();
        Ticket ticket = manager.park(car);
        Car fetch = manager.fetch(ticket);

        Assertions.assertSame(car,fetch);
    }
}
