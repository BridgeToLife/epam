package com.epam.tracks.command;

import com.epam.tracks.exception.CommandException;
import com.epam.tracks.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TakeAnOrderCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        OrderService service = new OrderService();
        //service.takeAnOrder(int orderId);


        return null;
    }
}
