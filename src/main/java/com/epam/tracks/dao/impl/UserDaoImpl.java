package com.epam.tracks.dao.impl;

import com.epam.tracks.builder.Builder;
import com.epam.tracks.builder.UserBuilder;
import com.epam.tracks.dao.AbstractDao;
import com.epam.tracks.dao.api.UserDao;
import com.epam.tracks.entity.User;
import com.epam.tracks.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String GET = "SELECT * FROM shop.user WHERE login = ? AND password = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM shop.user";
    private static final String GET_BY_NAME = "SELECT * FROM shop.user WHERE firstname = ? AND lastname = ?";
    private static final String UPDATE_USER_DATA = "UPDATE shop.user" +
                                                    " SET login = ?" +
                                                    " firstname = ?" +
                                                    " lastname = ?" +
                                                    " date_of_birth = ?" +
                                                    " phone_number = ?" +
                                                    " bonuse_points = 10" +
                                                    " orders_number = ?" +
                                                    " role = ?" +
                                                    " WHERE id = ?";

    public UserDaoImpl(Connection connection){
        super(connection);
    }


    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {


        try{
            Builder<User> builder = new UserBuilder();
            PreparedStatement statement = connection.prepareStatement(GET);

            statement.setString(1, login);
            statement.setString(2, password);

            return executeSimpleRead(statement, builder);

        }catch(SQLException ex){
         throw new DaoException();
        }

    }

    @Override
    public Set<User> findUserByName(String firstname, String lasname) throws DaoException {

        try {
            Builder<User> builder = new UserBuilder();

            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);

            statement.setString(1, firstname);
            statement.setString(2, lasname);

            return executeRead(statement, builder);
        }catch (SQLException ex){
            return null;
        }
    }

    @Override
    public User getById(Integer key) throws DaoException {
        return null;
    }

    @Override
    public Set<User> getAll() throws DaoException {

        try {

            Builder<User> builder = new UserBuilder();

            PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS);

            return executeRead(statement, builder);

        }catch (SQLException ex){
            throw new DaoException();
        }

    }

    @Override
    public void update(User object) throws DaoException {

        try(PreparedStatement statement = connection.prepareStatement(UPDATE_USER_DATA)){
            statement.setString(1, object.getLogin());
            statement.setString(2, object.getFirstName());
            statement.setString(3, object.getLastName());
            statement.setString(4, object.getDateOfBirth());
            statement.setString(5, object.getPhoneNumber());
            statement.setInt(6, object.getBonusPoints());
            statement.setInt(7, object.getOrderNumber());
            statement.setString(8, String.valueOf(object.getRole()));
            statement.setInt(9, object.getUserId());



        }catch (SQLException ex){
            throw new DaoException();
        }
    }
}

