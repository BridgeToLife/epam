package com.epam.tracks.dao.creator;

import com.epam.tracks.dao.impl.OrderDaoImpl;
import com.epam.tracks.dao.impl.TrackDaoImpl;
import com.epam.tracks.dao.impl.UserDaoImpl;
import com.epam.tracks.db.connection.ConnectionPool;
import com.epam.tracks.exception.ConnectionException;

import java.sql.Connection;

public class DaoCreator implements AutoCloseable {

    private ConnectionPool connectionPool;
    private Connection connection;

    public DaoCreator()throws ConnectionException {

        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }


    public UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl(connection);
    }

    public TrackDaoImpl getTrackDaoImpl(){
        return new TrackDaoImpl(connection);
    }

    public OrderDaoImpl getOrderDaoImpl(){
        return new OrderDaoImpl(connection);
    }

    @Override
    public void close() {

       connectionPool.returnConnection(connection);
    }
}
