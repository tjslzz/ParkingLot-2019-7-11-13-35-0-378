package com.thoughtworks.tdd;

import java.util.List;

public class Manager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public Manager(List<ParkingLot> parkingLots,List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public ParkingBoy chooseParkingBoy(Integer index){
        return parkingBoys.get(index);
    }
}
