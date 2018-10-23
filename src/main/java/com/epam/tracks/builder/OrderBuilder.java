package com.epam.tracks.builder;

import com.epam.tracks.entity.Order;
import com.epam.tracks.entity.api.PaymentMethod;
import com.epam.tracks.entity.api.ProcessingState;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBuilder implements Builder<Order>{

    private static final String ID = "id";
    private static final String USER_ID = "user_id";
    private static final String TRACK_ID = "track_id";
    private static final String PAYMENT = "payment_method";
    private static final String PROCESSING = "processing_status";
    private static final String COMMENT = "comment";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String DATE = "order_date";
    private static final String PRODUCER_ID = "producer_id";


    @Override
    public Order build(ResultSet resultSet) throws SQLException {



        int id = resultSet.getInt(ID);
        int userId = resultSet.getInt(USER_ID);
        int trackId = resultSet.getInt(TRACK_ID);
        int price = resultSet.getInt(PRICE);
        int producerId = resultSet.getInt(PRODUCER_ID);

        PaymentMethod payment = PaymentMethod.valueOf(resultSet.getString(PAYMENT));
        ProcessingState state = ProcessingState.valueOf(resultSet.getString(PROCESSING));

        String comment = resultSet.getString(COMMENT);
        String name = resultSet.getString(NAME);
        String date = resultSet.getString(DATE);


        Order order = new Order.Builder()
                .setComment(comment)
                .setDate(date)
                .setId(id)
                .setPaymentMethod(payment)
                .setName(name)
                .setPrice(price)
                .setProcessingState(state)
                .setTrackId(trackId)
                .setUserId(userId)
                .setProducerId(producerId)
                .build();

        return order;
    }


}
