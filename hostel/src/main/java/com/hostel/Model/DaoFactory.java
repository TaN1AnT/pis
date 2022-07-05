package com.hostel.Model;

import com.hostel.Model.Dao.*;

public class DaoFactory {
    public static UserDao createUserDao(){
        return new UserDao();
    }
    public static UserRoleDao createUserRoleDao(){
        return new UserRoleDao();
    }
    public static RoomDao createRoomDao(){return new RoomDao();}
    public static ClassDao createClassDao(){return new ClassDao();}
    public static UserRoomDao createUserRoomDao(){return new UserRoomDao();}
    public static OrderDao createOrderDao(){return new OrderDao();}
}
