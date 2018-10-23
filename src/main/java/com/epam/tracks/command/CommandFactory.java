package com.epam.tracks.command;

public class CommandFactory {

    public static Command create(String name){

        switch (name){
            case "login": return new LoginCommand();
            case "showUsers": return new ShowUsersCommand();
            case "findUser": return new FindUserCommand();
            case "preOrder": return new MakeOrderCommand();
            case "showOrders": return new ShowOrdersCommand();
            case "changeLocale": return new ChangeLocaleCommand();
            case "changeUserData": return new ChangeUserDataCommand();
            case "rejectOrder": return new RejectOrderCommand();
            case "bookOrder": return new MakeBookOrderCommand();
            default: return new LoginCommand();
        }
    }
}
