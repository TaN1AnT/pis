package com.hostel.Controller.Commands;

import com.hostel.Controller.ConfigPath;
import com.hostel.Model.Entities.User;
import com.hostel.Service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandRegister implements ICommand {
    UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = new User(
                null,
                username,
                password);
        if(userService.isUserUnique(username)){
            userService.createUser(user);
        }
        else {
            request.setAttribute("unique", false);
            return ConfigPath.register.getJspPath();
        }
        request.setAttribute("unique", true);
        session.setAttribute("registered", true);
        session.setAttribute("user", user);
        session.setAttribute("admin", false);
        return ConfigPath.home.getJspPath();
    }
}
