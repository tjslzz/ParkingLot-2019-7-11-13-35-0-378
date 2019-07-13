package com.thoughtworks.tdd;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private String errorMessage;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car){
        for(ParkingLot parkingLot : parkingLots){
            if(parkingLot.getParkingLot().size() < parkingLot.getCapacity()){
                Ticket ticket = parkingLot.park(car);
                this.errorMessage = parkingLot.getErrorMessage();
                return ticket;
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    public Car fetch(Ticket ticket){
        for(ParkingLot parkingLot : parkingLots){
            if(ticket == null){
                this.errorMessage = "Please provide your parking ticket.";
                return null;
            }
            else {
                Car car = parkingLot.fetch(ticket);
                this.errorMessage = parkingLot.getErrorMessage();
                if(car != null){
                    return car;
                }
            }
        }
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
