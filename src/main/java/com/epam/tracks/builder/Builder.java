package com.epam.tracks.builder;

import com.epam.tracks.entity.api.Identifible;
import com.epam.tracks.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Builder<T extends Identifible> {

    T build(ResultSet resultSet) throws SQLException, ServiceException;
}
