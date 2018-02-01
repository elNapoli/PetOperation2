package com.example.elnapoli.petoperation.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by elnapoli on 29-11-17.
 */


public class Pets  implements Serializable{
    private String name;
    private int photo;
    private int id;
    private int rating;
    private boolean isLike;
    private ArrayList<Photos> myPhotos;


    public  Pets(){

    }
    public Pets(String name, int photo){
        this.name = name;
        this.photo = photo;
        Random r = new Random();
        int lowerBound = 1;
        int upperBound = 11;
        this.rating = r.nextInt(upperBound-lowerBound) + lowerBound;
        this.isLike = false;
    }
    public boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public ArrayList<Photos> getMyPhotos() {
        return myPhotos;
    }

    public void setMyPhotos(ArrayList<Photos> myPhotos) {
        this.myPhotos = myPhotos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
