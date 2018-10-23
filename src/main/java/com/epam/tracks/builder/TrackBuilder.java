package com.epam.tracks.builder;

import com.epam.tracks.entity.Track;
import com.epam.tracks.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackBuilder implements Builder<Track> {

    @Override
    public Track build(ResultSet resultSet) throws SQLException, ServiceException {

        return null;
    }
}
