package com.hostel;

import com.hostel.Model.Dao.OrderDao;
import com.hostel.Model.Dao.RoomDao;
import com.hostel.Model.Dao.UserDao;
import com.hostel.Model.DaoFactory;
import com.hostel.Service.RoomService;

public class Entry {
    public static void main(String[] args) {
        OrderDao orderDao = DaoFactory.createOrderDao();
        System.out.println(orderDao.findAll());
        UserDao userDao = DaoFactory.createUserDao();
        System.out.println(userDao.findAll());
//        RoomDao roomDao = DaoFactory.createRoomDao();
//        RoomService roomService = new RoomService();
//        System.out.println(roomService.getAllRooms());

        System.out.println(orderDao.findById(2));
    }
}
