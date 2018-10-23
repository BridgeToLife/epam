package com.epam.tracks.command;

import com.epam.tracks.entity.User;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class FindUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");

            UserService service = new UserService();
            List<User> userList = service.showUsers(firstname, lastname);

            HttpSession session = request.getSession();
            session.removeAttribute("userList");
            session.setAttribute("userList", userList);

            return "/showUsers.jsp";
        }catch (ServiceException ex){
            throw new CommandException(ex);
        }
    }
}
