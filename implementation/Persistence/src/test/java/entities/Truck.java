package entities;

import businessentitiesapi.Entity;
import nl.fontys.sebivenlo.sebiannotations.ID;


/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class Truck implements Entity {

    @ID
    private Integer truckid;
    private String plate;

    public Truck(Integer truckid, String Plate) {
        this.truckid = truckid;
        this.plate = Plate;
    }


    public Integer getTruckid() {
        return truckid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String Plate) {
        this.plate = Plate;
    }

    Object[] asParts() {
        return new Object[]{
                this.truckid,
                this.plate
        };
    }

    @Override
    public int getId() {
        return 0;
    }
}
