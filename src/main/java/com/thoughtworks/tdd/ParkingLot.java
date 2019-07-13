package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingLot = new HashMap<>();
    private Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car){
        if(parkingLot.containsValue(car) || car == null){
            return null;
        }
        else{
            if(parkingLot.size()<capacity){
                Ticket ticket = new Ticket();
                parkingLot.put(ticket,car);
                return ticket;
            }
            else{
                return null;
            }
        }
    }

    public Car fetch(Ticket ticket){
        return parkingLot.remove(ticket);
    }
}
