package com.hostel.Controller;

public enum ConfigPath {
    home("/home.jsp"),
    login("/login.jsp"),
    register("/register.jsp"),
    profile("/profile.jsp"),
    users("/users.jsp"),
    orders("/orders.jsp"),
    room("/room.jsp")
    ;
    private final String jspPath;
    ConfigPath(String jspPath){
        this.jspPath = jspPath;
    }

    public String getJspPath() {
        return jspPath;
    }
}
