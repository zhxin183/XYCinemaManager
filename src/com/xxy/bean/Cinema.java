package com.xxy.bean;


public class Cinema {
    /**
     * 影院ID
     */
    public int id;
    /**
     * 影院名称
     */
    public String name;
    /**
     * 影院地址
     */
    public String address;
    /**
     * 影院标签
     */
    public String tag;
    /**
     * 评分
     */
    public float score;
    /**
     * 影院图片
     */
    public String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Cinema(int id, String name, String address, String tag, float score, String img) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tag = tag;
        this.score = score;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tag='" + tag + '\'' +
                ", score=" + score +
                ", img='" + img + '\'' +
                '}';
    }
}
