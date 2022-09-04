package com.xxy.bean;

public class Room {

    /**
     * 放映室ID
     */
    public int id;
    /**
     * 电影院ID
     */
    public int cinemaId;
    /**
     * 放映室名称
     */
    public String name;
    /**
     * 座位数量
     */
    public int seat;

    public Room(int id, int cinemaId, String name, int seat) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.name = name;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", name='" + name + '\'' +
                ", seat=" + seat +
                '}';
    }
}
