package com.epam.tracks.dao;

import com.epam.tracks.builder.Builder;
import com.epam.tracks.builder.UserBuilder;
import com.epam.tracks.entity.User;
import com.epam.tracks.entity.api.Identifible;
import com.epam.tracks.exception.DaoException;
import com.epam.tracks.exception.ServiceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractDao<T extends Identifible> {

    protected Connection connection;

    public AbstractDao(Connection connection){
        this.connection = connection;
    }

    public Set<T> executeRead(PreparedStatement statement, Builder<T> builder) throws DaoException{

        Set<T> simpleSet = new HashSet<T>();

        try{

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                T object = builder.build(resultSet);
                simpleSet.add(object);
            }

            return simpleSet;

        }catch(SQLException | ServiceException ex) {
            System.out.println(ex.getMessage());
            throw new DaoException();
        }
    }

    public Optional<T> executeSimpleRead(PreparedStatement statement, Builder<T> builder) throws DaoException{
        Set<T> simpleSet = executeRead(statement, builder);

        if(simpleSet.size() == 1){
            T object = simpleSet.iterator().next();
            return Optional.of(object);
        } else {
            throw new DaoException();
        }
    }

    public void executeWrite(String query, String... parameters){

    }


}
