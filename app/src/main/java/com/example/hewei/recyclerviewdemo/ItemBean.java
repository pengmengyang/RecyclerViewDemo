package com.example.hewei.recyclerviewdemo;

/**
 * Created by ${Administrator} on ${2016-06-07}.
 */

import java.io.Serializable;

/**
 * item实体类
 */
class ItemBean implements Serializable{

    private int drawbleID;
    private String drawbleName;

    public ItemBean(){

    }

    ItemBean(int drawbleID, String drawbleName){
        this.drawbleID=drawbleID;
        this.drawbleName=drawbleName;
    }

    int getDrawbleID() {
        return drawbleID;
    }

    public void setDrawbleID(int drawbleID) {
        this.drawbleID = drawbleID;
    }

    String getDrawbleName() {
        return drawbleName;
    }

    public void setDrawbleName(String drawbleName) {
        this.drawbleName = drawbleName;
    }
}
