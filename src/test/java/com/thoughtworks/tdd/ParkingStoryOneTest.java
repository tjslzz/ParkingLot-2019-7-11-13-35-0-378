package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingStoryOneTest {
    @Test
    public void shout_return_car_when_call_fetch_given_hasTicket(){
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(car);
        Car fetch = parkingBoy.fetch(ticket);
        Assertions.assertSame(car,fetch);
    }
}
