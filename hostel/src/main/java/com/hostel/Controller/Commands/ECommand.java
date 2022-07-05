package com.hostel.Controller.Commands;

public enum ECommand {
    home(new Home()),
    login(new Login()),
    register(new Register()),
    commandLogin(new CommandLogin()),
    commandRegister(new CommandRegister()),
    commandProfile(new CommandProfile()),
    logOut(new CommandLogOut()),
    usersList(new CommandUsersList()),
    deleteUser(new CommandDeleteUser()),
    confirmOrder(new CommandConfirmOrder()),
    deleteOrder(new CommandDeleteOrder()),
    ordersList(new CommandOrdersList()),
    roomsList(new CommandRoomsList()),
    addOrder(new CommandAddOrder())
    ;
    private final ICommand command;
    ECommand(ICommand command) {
        this.command = command;
    }
    public ICommand getCommand() { return command; }
}
