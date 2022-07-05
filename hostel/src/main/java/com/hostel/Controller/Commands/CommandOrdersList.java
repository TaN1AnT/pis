package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandOrdersList implements ICommand{
    OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin == null){
            return ConfigPath.home.getJspPath();
        }
        if(admin){
            request.setAttribute("orders", orderService.getAllOrders());
            return ConfigPath.orders.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
