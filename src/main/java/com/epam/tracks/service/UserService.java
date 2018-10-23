package com.epam.tracks.service;

import com.epam.tracks.dao.api.UserDao;
import com.epam.tracks.dao.creator.DaoCreator;
import com.epam.tracks.dao.impl.UserDaoImpl;
import com.epam.tracks.entity.User;
import com.epam.tracks.exception.ConnectionException;
import com.epam.tracks.exception.DaoException;
import com.epam.tracks.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserService {

    private static final Logger LOGGER = LogManager.getLogger();

    public Optional<User> login(String login, String password) throws ServiceException {

        try{
            DaoCreator daoCreator = new DaoCreator();
            UserDaoImpl userDao = daoCreator.getUserDaoImpl();
            Optional<User> user = userDao.findUserByLoginAndPassword(login, password);
            daoCreator.close();
            return user;
        }catch(DaoException | ConnectionException ex){
            throw new ServiceException(ex);
        }
    }

    public List<User> showUsers() throws ServiceException{

        try {
            DaoCreator daoCreator = new DaoCreator();
            UserDaoImpl userDao = daoCreator.getUserDaoImpl();

            Set<User> userSet = userDao.getAll();
            daoCreator.close();
            return new ArrayList<>(userSet);

        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        } finally {

        }
    }

    public List<User> showUsers(String firstname, String lastname) throws ServiceException{

        try {
            DaoCreator daoCreator = new DaoCreator();
            UserDaoImpl userDao = daoCreator.getUserDaoImpl();

            Set<User> userSet = userDao.findUserByName(firstname, lastname);
            daoCreator.close();
            return new ArrayList<>(userSet);

        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        }
    }


    public void updateUserData(User user) throws ServiceException{
        try {
            DaoCreator daoCreator = new DaoCreator();
            UserDaoImpl userDao = daoCreator.getUserDaoImpl();

            userDao.update(user);

            daoCreator.close();

        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        }
    }
}
