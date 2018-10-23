package com.epam.tracks.service;

import com.epam.tracks.dao.creator.DaoCreator;
import com.epam.tracks.dao.impl.OrderDaoImpl;
import com.epam.tracks.entity.Order;
import com.epam.tracks.exception.ConnectionException;
import com.epam.tracks.exception.DaoException;
import com.epam.tracks.exception.ServiceException;

import java.util.Set;

public class OrderService {

    public void cretePreOrder(String payment, String category, String duration, String comment, int userId) throws ServiceException {

        try{
            DaoCreator daoCreator = new DaoCreator();
            OrderDaoImpl orderDao = daoCreator.getOrderDaoImpl();

            orderDao.createPreOrder(payment, category, duration, comment, userId);
            daoCreator.close();
        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        }
    }

    public Set<Order> getAllOrders() throws ServiceException{

        try{
            DaoCreator daoCreator = new DaoCreator();
            OrderDaoImpl orderDao = daoCreator.getOrderDaoImpl();

            Set<Order> orders = orderDao.getAll();
            daoCreator.close();
            return orders;

        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        }
    }

    public void takeAnOrder(int orderId) throws ServiceException{

        try {
            DaoCreator daoCreator = new DaoCreator();
            OrderDaoImpl orderDao = daoCreator.getOrderDaoImpl();

            orderDao.takeAnOrder(orderId);
            daoCreator.close();

        }catch (DaoException | ConnectionException ex){

        }


    }

    public void rejectOrder(int orderId) throws  ServiceException{
        try {
            DaoCreator daoCreator = new DaoCreator();
            OrderDaoImpl orderDao = daoCreator.getOrderDaoImpl();

            orderDao.rejectOrder(orderId);
            daoCreator.close();

        }catch (DaoException | ConnectionException ex){

        }
    }

    public void bookOrder(int orderId, int producerId) throws ServiceException{

        try {
            DaoCreator daoCreator = new DaoCreator();
            OrderDaoImpl orderDao = daoCreator.getOrderDaoImpl();

            orderDao.bookOrder(orderId, producerId);
            daoCreator.close();

        }catch (DaoException | ConnectionException ex){
            throw new ServiceException();
        }
    }
}
