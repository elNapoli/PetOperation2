package com.example.elnapoli.petoperation.models;

/**
 * Created by elnapoli on 09-12-17.
 */

public class Photos {
    private int ranking;
    private int src;


    public Photos(int ranking, int src){
        this.ranking = ranking;
        this.src = src;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }
}
