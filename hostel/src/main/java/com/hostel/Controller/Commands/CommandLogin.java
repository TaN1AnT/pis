package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Model.Entities.User;
import com.hostel.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogin implements ICommand{
    UserService userService = new UserService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.isUserExists(username, password);
        if(user != null){
            session.setAttribute("registered", true);
            session.setAttribute("user", user);
            if(userService.isUserAdmin(user.id()))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            return ConfigPath.home.getJspPath();
        }
        else {
            request.setAttribute("incorrect", true);
            session.setAttribute("registered", false);
        }
        return ConfigPath.login.getJspPath();
    }
}
