package com.thoughtworks.tdd;

public class ParkingBoy {
    private Car car;
    public Ticket park(Car car){
        this.car = car;
        return new Ticket();
    }
    public Car fetch(Ticket ticket){
        return car;
    }
}
