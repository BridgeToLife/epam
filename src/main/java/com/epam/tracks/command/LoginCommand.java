package com.epam.tracks.command;


import com.epam.tracks.entity.User;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            UserService service = new UserService();
            User user = service.login(login, password).get();

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            return "/personalPage.jsp";

        } catch (ServiceException ex) {
            request.setAttribute("error", ex);
            return "/errorPage.jsp";
    }


    }
}
