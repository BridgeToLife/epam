package com.epam.tracks.dao.api;

import com.epam.tracks.entity.Track;
import com.epam.tracks.exception.DaoException;

import java.util.Optional;


public interface TrackDao extends Dao<Track> {

    public Optional<Track> findTrackByProducer() throws DaoException;
    public Optional<Track> findTrackByNameAndProducer() throws DaoException;
 }
