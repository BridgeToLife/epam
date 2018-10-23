package com.epam.tracks.dao.api;

import com.epam.tracks.entity.Order;
import com.epam.tracks.exception.DaoException;

import java.util.Optional;

public interface OrderDao extends Dao<Order> {
    Optional<Order> findeOrderByName() throws DaoException;
    Optional<Order> findeOrderByPrice() throws DaoException;
    void createOrder(Order order) throws DaoException;
    void updateOrderInformation(Order order) throws DaoException;
    void cancelOrder(Order order) throws DaoException;

    void createPreOrder(String payment, String category, String duration, String comment, int userId) throws DaoException;
}
