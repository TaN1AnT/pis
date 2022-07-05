package com.hostel.Service;

import com.hostel.Model.Dao.ClassDao;
import com.hostel.Model.Dao.OrderDao;
import com.hostel.Model.Dao.RoomDao;
import com.hostel.Model.Dao.UserRoomDao;
import com.hostel.Model.DaoFactory;
import com.hostel.Model.Entities.Class;
import com.hostel.Model.Entities.Order;
import com.hostel.Model.Entities.UserRoom;
import com.hostel.Service.Dto.OrderDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    final private OrderDao orderDao = DaoFactory.createOrderDao();
    final private ClassDao classDao = DaoFactory.createClassDao();
    final private RoomDao roomDao = DaoFactory.createRoomDao();
    final private UserRoomDao userRoomDao = DaoFactory.createUserRoomDao();
    public List<OrderDto> getAllOrders(){
        return orderDao.findAll()
                .stream()
                .map(order -> new OrderDto(
                        order.id(),
                        order.places(),
                        classDao.findById(order.class_id()).name(),
                        order.user_id()))
                .collect(Collectors.toList());
    }
    public void deleteOrder(Integer id){
        orderDao.delete(id);
    }

    public void confirmOrder(Integer order_id, Integer room_id){
        if(userRoomDao.findById(room_id)==null){
            userRoomDao.add(new UserRoom(orderDao.findById(order_id).user_id(), room_id));
            orderDao.delete(order_id);
        }
    }

    public void addOrder(Integer places, Integer class_id, Integer user_id){
        orderDao.add(new Order(
                null,
                places,
                class_id,
                user_id
        ));
    }
}
