package com.epam.tracks.command;

import com.epam.tracks.entity.User;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeBookOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            User user = (User) request.getAttribute("user");

            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int producerId = user.getUserId();

            OrderService service = new OrderService();
            service.bookOrder(orderId, producerId);

            return "/ordersPage.jsp";
        }catch (ServiceException ex){
            throw new CommandException();
        }
    }
}
