package com.epam.tracks.dao.impl;

import com.epam.tracks.dao.AbstractDao;
import com.epam.tracks.dao.api.TrackDao;
import com.epam.tracks.entity.Track;
import com.epam.tracks.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.Set;

public class TrackDaoImpl extends AbstractDao<Track> implements TrackDao {

    private Connection connection;

    public TrackDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Optional<Track> findTrackByProducer() throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Track> findTrackByNameAndProducer() throws DaoException {
        return Optional.empty();
    }

    @Override
    public Track getById(Integer key) throws DaoException {
        return null;
    }

    @Override
    public Set<Track> getAll() throws DaoException {
        return null;
    }

    @Override
    public void update(Track object) throws DaoException {

    }
}
