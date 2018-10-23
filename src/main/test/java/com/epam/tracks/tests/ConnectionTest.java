package com.epam.tracks.tests;


import com.epam.tracks.entity.User;
import com.epam.tracks.exception.ServiceException;
import com.epam.tracks.service.UserService;
import org.junit.Test;

import javax.servlet.http.HttpSession;


public class ConnectionTest {

    @Test
    public void test() throws Exception{
        try {
            String login = "user";
            String password = "user";

            UserService service = new UserService();
            User user = service.login(login, password).get();



        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }






    }
}
