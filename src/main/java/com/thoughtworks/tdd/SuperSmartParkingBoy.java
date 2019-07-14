package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) { super(parkingLots); }

    @Override
    public Ticket park(Car car) { return lotPark(parkingLots.stream().reduce((pre,cur)->pre.getEmpty()/pre.getCapacity() >= cur.getEmpty()/cur.getCapacity()?pre:cur).orElse(null),car); }
}
