package com.thoughtworks.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BasicParkingBoy extends ParkingBoy{

    public BasicParkingBoy(List<ParkingLot> parkingLots) { super(parkingLots); }

    @Override
    public Ticket park(Car car){
        try{
            ParkingLot parkingLot = parkingLots.stream().filter(p -> p.getEmpty() > 0).collect(Collectors.toList()).get(0);
            Ticket ticket  = parkingLot.park(car);
            this.errorMessage = parkingLot.getErrorMessage();
            return ticket;
        }
        catch (Exception e){ this.errorMessage = "Not enough position.";return null; }
    }
}
