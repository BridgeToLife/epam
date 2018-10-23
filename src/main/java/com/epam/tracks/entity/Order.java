package com.epam.tracks.entity;

import com.epam.tracks.entity.api.Identifible;
import com.epam.tracks.entity.api.PaymentMethod;
import com.epam.tracks.entity.api.ProcessingState;

public class Order implements Identifible {

    private int id;
    private int userId;
    private int trackId;
    private int producerId;
    private PaymentMethod paymentMethod;
    private ProcessingState processingState;
    private String comment;
    private String name;
    private int price;
    private String date;

    private Order(Builder builder){
        this.id = builder.id;
        this.userId = builder.userId;
        this.trackId = builder.trackId;
        this.paymentMethod = builder.paymentMethod;
        this.processingState = builder.processingState;
        this.comment = builder.comment;
        this.name = builder.name;
        this.price = builder.price;
        this.date = builder.date;
        this.producerId = builder.producerId;
    }


    public static class Builder{

        private int id;
        private int userId;
        private int trackId;
        private int producerId;
        private PaymentMethod paymentMethod;
        private ProcessingState processingState;
        private String comment;
        private String name;
        private int price;
        private String date;

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setProcessingState(ProcessingState processingState) {
            this.processingState = processingState;
            return this;
        }

        public Builder setTrackId(int trackId) {
            this.trackId = trackId;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setProducerId(int producerId){
            this.producerId = producerId;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }


    public int getTrackId() {
        return trackId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getPrice() {
        return price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public ProcessingState getProcessingState() {
        return processingState;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getProducerId() {
        return producerId;
    }
}
