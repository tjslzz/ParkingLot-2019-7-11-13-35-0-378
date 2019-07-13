package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingLot = new HashMap<>();

    public Ticket park(Car car){
        Ticket ticket = new Ticket();
        parkingLot.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        return parkingLot.remove(ticket);
    }
}
