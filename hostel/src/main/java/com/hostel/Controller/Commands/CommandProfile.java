package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Model.Entities.Room;
import com.hostel.Model.Entities.User;
import com.hostel.Service.ClassService;
import com.hostel.Service.RoomService;
import com.hostel.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProfile implements ICommand{
    UserService userService = new UserService();
    RoomService roomService = new RoomService();
    ClassService classService= new ClassService();

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            request.setAttribute("classes", classService.getAllClasses());
            request.setAttribute("rooms", roomService.getUserRooms(((User)session.getAttribute("user")).id()));
            return ConfigPath.profile.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
