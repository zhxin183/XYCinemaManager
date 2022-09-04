package com.xxy.bean;

public class Arrange {
    public int id;

    public int cinemaId;
    public String cinemaName;

    public int roomId;
    public String roomName;

    public int filmId;
    public String filmName;

    public int beginTime;
    public int endTime;
    public float price;

    public Arrange(int id, int cinemaId, String cinemaName, int roomId, String roomName, int filmId, String filmName, int beginTime, int endTime, float price) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.roomId = roomId;
        this.roomName = roomName;
        this.filmId = filmId;
        this.filmName = filmName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.price = price;
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

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Arrange{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", price=" + price +
                '}';
    }
}
