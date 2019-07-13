package com.thoughtworks.tdd;

import java.util.List;

public class Manager{
    private List<ParkingBoy> parkingBoys;

    public Manager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public ParkingBoy chooseParkingBoy(Integer index){
        return parkingBoys.get(index);
    }
}
