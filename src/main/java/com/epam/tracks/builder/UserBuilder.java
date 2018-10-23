package com.epam.tracks.builder;

import com.epam.tracks.entity.User;
import com.epam.tracks.entity.api.Role;
import com.epam.tracks.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserBuilder implements Builder<User> {

    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String BIRTHDAY_DATE = "date_of_birth";
    private static final String REGION = "region";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String BONUSE_POINTS = "bonuse_points";
    private static final String ORDERS_NUMBER = "orders_number";
    private static final String ROLE = "role";
    private static final String LOCALE = "locale";


    @Override
    public User build(ResultSet resultSet) throws SQLException, ServiceException {

        Role role = Role.valueOf(resultSet.getString(ROLE));
        int id = Integer.parseInt(resultSet.getString(ID));
        String login = resultSet.getString(LOGIN);
        String password = resultSet.getString(PASSWORD);
        String firstname = resultSet.getString(FIRSTNAME);
        String lastname = resultSet.getString(LASTNAME);
        String birthday = resultSet.getString(BIRTHDAY_DATE);
        String region = resultSet.getString(REGION);
        String phone = resultSet.getString(PHONE_NUMBER);
        int bonuse = Integer.parseInt(resultSet.getString(BONUSE_POINTS));
        int orders = Integer.parseInt(resultSet.getString(ORDERS_NUMBER));

        User user = new User.Builder(role, id)
                            .setLogin(login)
                            .setPassword(password)
                            .setFirstName(firstname)
                            .setLastName(lastname)
                            .setDateOfBirth(birthday)
                            .setRegion(region)
                            .setPhoneNumber(phone)
                            .setBonudePoints(bonuse)
                            .setOrderNumber(orders)
                            .build();

        return user;
    }




}
