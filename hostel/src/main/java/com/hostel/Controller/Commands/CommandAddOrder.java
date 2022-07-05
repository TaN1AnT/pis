package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Model.Entities.User;
import com.hostel.Service.ClassService;
import com.hostel.Service.OrderService;
import com.hostel.Service.RoomService;
import com.hostel.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandAddOrder implements ICommand{
    OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            orderService.addOrder(
                    Integer.parseInt(request.getParameter("places")),
                    Integer.parseInt(request.getParameter("class_")),
                    ((User)session.getAttribute("user")).id()
            );
            return ECommand.commandProfile.getCommand().execute(request);
        }
        return ConfigPath.home.getJspPath();
    }
}
