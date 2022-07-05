package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteUser implements ICommand{
    UserService userService = new UserService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            userService.deleteUser(Integer.parseInt(request.getParameter("user_id")));
            return ECommand.usersList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspPath();
    }
}
