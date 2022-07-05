package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandRoomsList implements ICommand{
    RoomService roomService = new RoomService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered == null){
            return ConfigPath.home.getJspPath();
        }
        if(registered){
            request.setAttribute("rooms", roomService.getAllRooms());
            return ConfigPath.room.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
