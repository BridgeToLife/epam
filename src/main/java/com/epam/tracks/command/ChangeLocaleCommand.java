package com.epam.tracks.command;

import com.epam.tracks.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {


                HttpSession session = request.getSession();

                String locale = request.getParameter("locale");

                session.setAttribute("locale", locale);

                return "/home.jsp";

    }
}
