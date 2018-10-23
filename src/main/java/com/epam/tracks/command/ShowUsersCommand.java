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

public class ShowUsersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            UserService service = new UserService();
            List<User> userSet = service.showUsers();

            HttpSession session = request.getSession();
            session.setAttribute("userList", userSet);

            return "/showUsers.jsp";
        }catch (ServiceException ex){
            throw new CommandException(ex);
        }
    }
}
