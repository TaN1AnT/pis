package com.hostel.Controller.Servlet;

import com.hostel.Controller.Commands.ECommand;
import com.hostel.Controller.Commands.ICommand;


import javax.servlet.http.HttpServletRequest;

public class ServletHelper {
    public static ICommand getCommand(HttpServletRequest request){
        String name = request.getParameter("command");
        if(name == null) return ECommand.home.getCommand();
        try{
            return ECommand.valueOf(name).getCommand();
        }catch (IllegalArgumentException e){
            return ECommand.home.getCommand();
        }
    }
}
