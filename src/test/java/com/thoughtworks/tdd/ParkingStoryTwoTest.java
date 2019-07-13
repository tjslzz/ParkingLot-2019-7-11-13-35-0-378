package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingStoryTwoTest {
    @Test
    public void shout_return_error_message_when_call_fetch_given_usedTicket_or_wrongTicket(){
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        Car fetch1 = parkingBoy.fetch(ticket);
        Car fetch2 = parkingBoy.fetch(null);

        Assertions.assertSame(null,fetch1);
        Assertions.assertSame(null,fetch2);
        Assertions.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMessage());
    }

    @Test
    public void shout_return_error_message_when_call_fetch_given_nullTicket(){
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.fetch(null);
        Assertions.assertEquals("Please provide your parking ticket.",parkingBoy.getErrorMessage());
    }

    @Test
    public void shout_return_error_message_when_call_fetch_given_hasTicket_whit_limited_Lot(){
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        parkingBoy.park(new Car());
        Assertions.assertEquals("Not enough position.",parkingBoy.getErrorMessage());
    }
}
