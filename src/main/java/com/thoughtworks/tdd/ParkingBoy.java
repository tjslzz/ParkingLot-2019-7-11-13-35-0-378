package com.thoughtworks.tdd;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLots;
    protected String errorMessage;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket park(Car car);

    public Car fetch(Ticket ticket){
        try{
            if(ticket == null){ this.errorMessage = "Please provide your parking ticket.";return null; }
            else {
                ParkingLot parkingLot = parkingLots.stream().filter(p ->p.getParkingLot().containsKey(ticket)).collect(Collectors.toList()).get(0);
                Car car = parkingLot.fetch(ticket);
                this.errorMessage = parkingLot.getErrorMessage();
                return car;
            }
        }
        catch (Exception e){ this.errorMessage = "Unrecognized parking ticket.";return null; }
    }

    public String getErrorMessage() { return errorMessage; }
    public List<ParkingLot> getParkingLots() { return parkingLots; }

    public Ticket lotPark(ParkingLot parkingLot,Car car){
        try{
            Ticket ticket = parkingLot.park(car);
            this.errorMessage = parkingLot.getErrorMessage();
            return ticket;
        }
        catch (Exception e){ this.errorMessage = "Not enough position.";return null; }
    }
}
