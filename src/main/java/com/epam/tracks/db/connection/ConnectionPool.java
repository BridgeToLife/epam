package com.epam.tracks.db.connection;

import com.epam.tracks.exception.ConnectionException;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConnectionPool  {

    private Lock lock = new ReentrantLock();
    private Set<Connection> pool = new HashSet<>();
    private Set<Connection> poolLibrary = new HashSet<>();
    private static final int CONNECTION_LIMIT = 20;

    private final Semaphore SEMAPHORE = new Semaphore(CONNECTION_LIMIT, true);

    private ConnectionPool(){

    }

    private static class ConnectionPoolHolder{
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance(){
        return ConnectionPoolHolder.INSTANCE;
    }

    public Connection getConnection() throws ConnectionException {

        try {

            SEMAPHORE.acquire();
            lock.lock();
            Connection connection;

            if(pool.isEmpty()){
                connection = ConnectionCreator.getConnection();
                poolLibrary.add(connection);
            } else {
                connection = pool.stream().findFirst().get();
                pool.remove(connection);
            }

            return connection;

        }catch (InterruptedException ex){
            throw new ConnectionException(ex.getMessage(), ex);
        } finally {
            lock.unlock();
        }

    }

    public void returnConnection(Connection connection){
        lock.lock();
        pool.add(connection);
        lock.unlock();
    }
}
