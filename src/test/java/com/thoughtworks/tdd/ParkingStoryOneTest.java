package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingStoryOneTest {
    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.park(car);
        Car fetch = parkingBoy.fetch(ticket);

        Assertions.assertSame(car,fetch);
    }

    @Test
    public void shout_return_car_when_call_fetch_given_correctTicket_with_manyCars(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        Car fetch = parkingBoy.fetch(ticket2);

        Assertions.assertSame(car2,fetch);
    }

    @Test
    public void shout_return_null_when_call_fetch_given_wrongTicket_or_NoTicket(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.park(car1);
        parkingBoy.park(car2);
        Car fetch1 = parkingBoy.fetch(new Ticket());
        Car fetch2 = parkingBoy.fetch(null);

        Assertions.assertSame(null,fetch1);
        Assertions.assertSame(null,fetch2);
    }

    @Test
    public void shout_return_null_when_call_fetch_given_usedTicket(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket1 = parkingBoy.park(car1);
        parkingBoy.park(car2);
        parkingBoy.fetch(ticket1);
        Car fetch = parkingBoy.fetch(ticket1);

        Assertions.assertSame(null,fetch);
    }

    @Test
    public void shout_return_null_when_call_fetch_given_hasTicket_whit_limited_Lot(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(new Car());

        Assertions.assertSame(null,ticket);
    }

    @Test
    public void shout_return_null_when_call_fetch_given_nullCar_or_parkedCar(){
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        parkingBoy.park(car);
        Ticket ticket1 = parkingBoy.park(car);
        Ticket ticket2 = parkingBoy.park(null);

        Assertions.assertSame(null,ticket1);
        Assertions.assertSame(null,ticket2);
    }
}
