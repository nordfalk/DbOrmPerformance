package com.maciejkozlowski.databases.serialisering;

import java.io.Serializable;

public class CityDao implements Serializable {

    private long id;
    private String name;
    private double latitude;
    private double longitude;

    public CityDao(long cityId, String name, double latitude, double longitude) {
        this.id = cityId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
