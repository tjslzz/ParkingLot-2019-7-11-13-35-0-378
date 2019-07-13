package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket,Car> parkingLot = new HashMap<>();
    private Integer capacity;
    private String errorMessage;
    private Integer empty;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.empty = capacity;
    }

    public Ticket park(Car car){
        if(parkingLot.containsValue(car) || car == null) return null;
        else{
            Ticket ticket = new Ticket();
            parkingLot.put(ticket,car);
            this.empty--;
            return ticket;
        }
    }

    public Car fetch(Ticket ticket){
        Car car = parkingLot.remove(ticket);
        if(car == null)errorMessage = "Unrecognized parking ticket.";
        else empty ++;
        return car;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getEmpty() {
        return empty;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
