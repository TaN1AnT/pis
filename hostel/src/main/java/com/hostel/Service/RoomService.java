package com.hostel.Service;

import com.hostel.Model.Dao.ClassDao;
import com.hostel.Model.Dao.RoomDao;
import com.hostel.Model.Dao.UserRoomDao;
import com.hostel.Model.DaoFactory;
import com.hostel.Model.Entities.Room;
import com.hostel.Model.Entities.UserRoom;
import com.hostel.Service.Dto.OrderDto;
import com.hostel.Service.Dto.RoomDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService {
    final private RoomDao roomDao = DaoFactory.createRoomDao();
    final private ClassDao classDao = DaoFactory.createClassDao();
    final private UserRoomDao userRoomDao = DaoFactory.createUserRoomDao();
    public void deleteRoom(Integer id){
        roomDao.delete(id);
    }

    public void addRoom(Integer number, Integer places, Integer class_id){
        roomDao.add(new Room(null,number,places,class_id));
    }

    public List<RoomDto> getAllRooms(){
        return roomDao.findAll()
                .stream()
                .filter(room -> userRoomDao.isRoomFree(room.id()))
                .map(room -> new RoomDto(
                        room.id(),
                        room.number(),
                        room.places(),
                        classDao.findById(room.class_id()).name()
                       ))
                .collect(Collectors.toList());
    }

    public List<RoomDto> getUserRooms(Integer user_id){
        List<Integer> user_rooms = userRoomDao.findAll()
                .stream()
                .filter(userRoom -> userRoom.user_id() == user_id)
                .map(userRoom -> userRoom.room_id())
                .collect(Collectors.toList());
        return roomDao.findAll()
                .stream()
                .filter(room -> user_rooms.contains(room.id()))
                .map(room -> new RoomDto(
                        room.id(),
                        room.number(),
                        room.places(),
                        classDao.findById(room.class_id()).name()
                ))
                .collect(Collectors.toList());
    }
}
