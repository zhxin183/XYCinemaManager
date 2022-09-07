package com.xxy.util;

import com.xxy.bean.Arrange;
import com.xxy.bean.Cinema;
import com.xxy.bean.Room;

import java.util.ArrayList;

/**
 * 测试数据
 */
public class TestDataUtil {

    public static ArrayList<Cinema> getCinemaList() {
        ArrayList<Cinema> listCinema = new ArrayList<>();
        listCinema.add(new Cinema(1, "惠州江北-中影国际影城", "广东省惠州市惠城区惠州大道佳兆业中心4楼", "退 改签", 9.3f, ""));
        listCinema.add(new Cinema(2, "惠州江北-华贸国际影城", "广东省惠州市惠城区华贸中心", "退 改签", 9.1f, ""));
        listCinema.add(new Cinema(3, "中影国际-中海店", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(4, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(5, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(6, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(7, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(8, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        listCinema.add(new Cinema(9, "惠州中海国际影城", "广东省惠州市惠城区中海生活汇", "退 改签", 9.5f, ""));
        return listCinema;
    }

    public static ArrayList<Room> getRoomList() {
        ArrayList<Room> listRoom = new ArrayList<>();
        listRoom.add(new Room(1, 1,"3D巨幕厅", 56));
        listRoom.add(new Room(2, 1,"2号厅", 24));
        listRoom.add(new Room(3, 1,"3号厅", 24));
        listRoom.add(new Room(4, 1,"4号厅", 36));
        listRoom.add(new Room(5, 2,"1号厅", 32));
        listRoom.add(new Room(6, 2,"2号厅", 32));
        listRoom.add(new Room(7, 2,"3号厅", 24));
        listRoom.add(new Room(8, 3,"iMax厅", 48));
        listRoom.add(new Room(9, 3,"2号厅", 32));
        listRoom.add(new Room(10, 3,"3号厅", 32));
        return listRoom;
    }

    public static ArrayList<Arrange> getArrangeList() {
        ArrayList<Arrange> listArrange = new ArrayList<>();
        listArrange.add(new Arrange(1, 1, "惠州江北-中影国际影城", 1, "3D巨幕厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));
        listArrange.add(new Arrange(2, 1, "惠州江北-中影国际影城", 2, "2号厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));
        listArrange.add(new Arrange(3, 1, "惠州江北-中影国际影城", 3, "3号厅", 1, "猫和老鼠", 1662299098, 1662303657, 35.9f));
        return listArrange;
    }
}
