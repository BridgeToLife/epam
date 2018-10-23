package com.epam.tracks.command;

import com.epam.tracks.entity.User;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class MakeOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            String payment = request.getParameter("payment");
            String category = request.getParameter("category");
            String duration = request.getParameter("duration");
            String comment = request.getParameter("comment");

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int userId = user.getUserId();

            OrderService service = new OrderService();
            service.cretePreOrder(payment, category, duration, comment, userId);

            return "/personalPage.jsp";

        }catch (ServiceException ex){
            throw new CommandException(ex);
        }
    }
}
