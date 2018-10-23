package com.epam.tracks.command;

import com.epam.tracks.entity.User;
import com.epam.tracks.entity.api.Role;
import com.epam.tracks.exception.CommandException;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeUserDataCommand implements Command {

    private static final String ROLE_INPUT= "role";
    private static final String LOGIN_INPUT= "login";
    private static final String FIRSTNAME_INPUT= "firstName";
    private static final String LASTNAME_INPUT= "lastName";
    private static final String PHONE_INPUT= "phone";
    private static final String BIRTH_INPUT= "birth";
    private static final String ORDERS_INPUT= "orders";
    private static final String BONUS_INPUT= "bonus";
    private static final String USER_ID_INPUT= "userId";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        try {
            int userId = Integer.parseInt(request.getParameter(USER_ID_INPUT));
            int bonusPoints = Integer.parseInt(request.getParameter(BONUS_INPUT));
            int orderNumber = Integer.parseInt(request.getParameter(ORDERS_INPUT));
            String firstName = request.getParameter(FIRSTNAME_INPUT);
            String lastName = request.getParameter(LASTNAME_INPUT);
            String login = request.getParameter(LOGIN_INPUT);
            String dateOfBirth = request.getParameter(BIRTH_INPUT);
            Role role = Role.valueOf(request.getParameter(ROLE_INPUT));
            String phoneNumber = request.getParameter(PHONE_INPUT);


            User user = new User.Builder(role, userId).setBonudePoints(bonusPoints)
                    .setOrderNumber(orderNumber)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setLogin(login)
                    .setDateOfBirth(dateOfBirth)
                    .setPhoneNumber(phoneNumber)
                    .build();
            UserService service = new UserService();
            service.updateUserData(user);
            return "/home.jsp";

        }catch (ServiceException ex){
            return "/home.jsp";
        }




    }
}


