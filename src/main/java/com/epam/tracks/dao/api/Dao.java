package com.epam.tracks.dao.api;

import com.epam.tracks.entity.User;
import com.epam.tracks.entity.api.Identifible;
import com.epam.tracks.exception.DaoException;

import java.util.Optional;
import java.util.Set;

public interface Dao<T extends Identifible> {

    public T getById(Integer key) throws DaoException;
    public Set<T> getAll() throws DaoException;
    public void update(T object) throws DaoException;
}
