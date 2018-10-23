package com.epam.tracks.command;

import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RejectOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
           int orderId = Integer.parseInt(request.getParameter("orderId"));

            OrderService service = new OrderService();
            service.rejectOrder(orderId);

            return "/ordersPage.jsp";
        }catch (ServiceException ex){
           return "/home.jsp";
        }


    }
}
