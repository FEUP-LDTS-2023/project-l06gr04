package org.example;

public class Enemy1 extends Enemy{
    int id;
    public Enemy1(double speed, int totHP, double x, double y, int id){
        super(speed,totHP,x,y);
        this.id = id;
    }
}
