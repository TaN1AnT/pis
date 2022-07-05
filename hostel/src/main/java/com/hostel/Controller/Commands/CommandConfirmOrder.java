package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandConfirmOrder implements ICommand{
    OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            orderService.confirmOrder(
                    Integer.parseInt(request.getParameter("order_id")),
                    Integer.parseInt(request.getParameter("room_id")));
        }
        return ECommand.ordersList.getCommand().execute(request);
    }
}
