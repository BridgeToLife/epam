package com.epam.tracks.dao.api;

import com.epam.tracks.entity.User;
import com.epam.tracks.exception.DaoException;

import java.util.Optional;
import java.util.Set;

public interface UserDao extends Dao<User> {
    public Optional<User> findUserByLoginAndPassword(String login, String password)throws DaoException;
    public Set<User> findUserByName(String firstname, String lasname) throws DaoException;

}
