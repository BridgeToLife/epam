package com.epam.tracks.command;

import com.epam.tracks.entity.Order;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class ShowOrdersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            OrderService service = new OrderService();
            Set<Order> orderSet = service.getAllOrders();

            HttpSession session = request.getSession();
            session.setAttribute("orders", orderSet);

            return "/ordersPage.jsp";
        }catch (ServiceException ex){
            throw new CommandException(ex);
        }


    }
}
