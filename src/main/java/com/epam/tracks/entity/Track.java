package com.epam.tracks.entity;

import com.epam.tracks.entity.api.Identifible;

public class Track implements Identifible {

    private long trackId;
    private long categoryId;
    private String producer;
    private String title;
    private int duration;
    private String uploadDate;
    private String url;

    private Track(Builder builder){
        this.trackId = builder.trackId;
        this.categoryId = builder.categoryId;
        this.producer = builder.producer;
        this.title = builder.title;
        this.duration = builder.duration;
        this.uploadDate = builder.uploadDate;
        this.url = builder.url;
    }

    public static class Builder{
        private long trackId;
        private long categoryId;
        private String producer;
        private String title;
        private int duration;
        private String uploadDate;
        private String url;

        public Builder setTrackId(long trackId){
            this.trackId = trackId;
            return this;
        }

        public Builder setCategoryId(long categoryId){
            this.categoryId = categoryId;
            return this;
        }

        public Builder setProducer(String producer){
            this.producer = producer;
            return this;
        }

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setDuration(int duration){
            this.duration = duration;
            return this;
        }

        public Builder setUploadDate(String uploadDate){
            this.uploadDate = uploadDate;
            return this;
        }

        public Builder setUrl(String url){
            this.url = url;
            return this;
        }

        public Track build(){
            return new Track(this);
        }
    }


    public int getDuration() {
        return duration;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public long getTrackId() {
        return trackId;
    }

    public String getProducer() {
        return producer;
    }

    public String getTitle() {
        return title;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getUrl() {
        return url;
    }
}
