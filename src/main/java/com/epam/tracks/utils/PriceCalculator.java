package com.epam.tracks.utils;

public class PriceCalculator {

    public static int calculatePrice(String category, int duration){

        int rezult = 0;

        if(category.equals("pop")){
            rezult += duration*100;
        }

        if(category.equals("rock")){
            rezult += duration*100;
        }

        if(category.equals("hip-hop")){
            rezult += duration*100;
        }

        if(category.equals("rap")){
            rezult += duration*100;
        }

        if(category.equals("house")){
            rezult += duration*100;
        }

        if(category.equals("trance")){
            rezult += duration*100;
        }

        if(category.equals("intro")){
            rezult += duration*100;
        }

        if(category.equals("relax")){
            rezult += duration*100;
        }

        if(category.equals("rington")){
            rezult += duration*100;
        }

        if(category.equals("new school")){
            rezult += duration*100;
        }

        if(category.equals("atmosphere")){
            rezult += duration*100;
        }

        return rezult;
    }
}
