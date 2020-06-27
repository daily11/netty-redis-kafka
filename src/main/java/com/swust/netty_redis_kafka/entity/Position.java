package com.swust.netty_redis_kafka.entity;

/**
 * 位置数据
 */
public class Position {
    private Double lon;
    private Double lat;

    public Position() {
    }

    public Position(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
