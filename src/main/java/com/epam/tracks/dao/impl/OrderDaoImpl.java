package com.epam.tracks.dao.impl;

import com.epam.tracks.builder.OrderBuilder;
import com.epam.tracks.dao.AbstractDao;
import com.epam.tracks.dao.api.Dao;
import com.epam.tracks.dao.api.OrderDao;
import com.epam.tracks.entity.Order;
import com.epam.tracks.exception.DaoException;
import com.epam.tracks.utils.PriceCalculator;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    public static final String TAKE_AN_ORDER = "UPDATE shop.order (processing_state) VALUES (PROCESSED) WHERE id=?";

    private static final String CREATE_PRE_ORDER = "INSERT INTO shop.order (user_id," +
                                                                            " track_id," +
                                                                            " payment_method," +
                                                                            " processing_status," +
                                                                            " comment," +
                                                                            " order_date, " +
                                                                            " name, " +
                                                                            " price)" +
                                                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String REJECT_ORDER = "DELETE FROM shop.order WHERE id = ?";
    private static final String BOOK_ORDER = "UPDATE shop.order SET processing_status = 'PROCESSED' producer_id = ? WHERE id = ?";

    private static final String GET_ALL = "SELECT * FROM shop.order";

    public OrderDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Optional<Order> findeOrderByName() throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Order> findeOrderByPrice() throws DaoException {
        return Optional.empty();
    }

    @Override
    public void createOrder(Order order) throws DaoException {

    }

    @Override
    public void updateOrderInformation(Order order) throws DaoException {

    }

    @Override
    public void cancelOrder(Order order) throws DaoException {

    }

    @Override
    public void createPreOrder(String payment, String category, String duration, String comment, int userId) throws DaoException {

        try(PreparedStatement statement = connection.prepareStatement(CREATE_PRE_ORDER)){

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();

            String name = category +" " + duration + " ";
            String commentForOrder = "category: " + category + ". duration: " + duration + ". comment: " + comment;

            int durationMinute = Integer.parseInt(duration);
            int price = PriceCalculator.calculatePrice(category, durationMinute);

            statement.setInt(1, userId);
            statement.setInt(2, 0);
            statement.setString(3, payment);
            statement.setString(4, "WAITING");
            statement.setString(5, commentForOrder);
            statement.setString(6, dateTimeFormatter.format(localDateTime));
            statement.setString(7, name);
            statement.setInt(8, price);


            statement.execute();

        }catch (SQLException ex){
            throw new DaoException();
        }
    }

    @Override
    public Order getById(Integer key) throws DaoException {
        return null;
    }

    @Override
    public Set<Order> getAll() throws DaoException {

        Set<Order> orders = new HashSet<>();
        OrderBuilder builder = new OrderBuilder();

        try(PreparedStatement statement = connection.prepareStatement(GET_ALL)){

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Order order = builder.build(resultSet);
                orders.add(order);
            }

            return orders;

        }catch (SQLException ex){
            throw new DaoException();
        }
    }

    @Override
    public void update(Order object) throws DaoException {

    }

    public void takeAnOrder(int orderId) throws DaoException{
        try(PreparedStatement statement = connection.prepareStatement(TAKE_AN_ORDER)){
            statement.setInt(1, orderId);
            statement.execute();

        }catch (SQLException ex){
            throw new DaoException();
        }
    }

    public void rejectOrder(int orderId) throws DaoException{

        try(PreparedStatement statement = connection.prepareStatement(REJECT_ORDER)){
            statement.setInt(1, orderId);
            statement.execute();

        }catch (SQLException ex){
            throw new DaoException();
        }
    }

    public void bookOrder(int orderId, int producerId) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(BOOK_ORDER)){
            statement.setInt(1, producerId);
            statement.setInt(2, orderId);

            statement.execute();

        }catch (SQLException ex){
            throw new DaoException();
        }
    }
}
