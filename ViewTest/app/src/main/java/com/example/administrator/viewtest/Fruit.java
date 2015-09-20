package com.example.administrator.viewtest;

/**
 * Created by Administrator on 2015/9/13.
 */
public class Fruit {
    private String name;
    private  int imageId;
    public  Fruit(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return this.name;
    }

    public int getImageId(){
        return this.imageId;
    }

}
