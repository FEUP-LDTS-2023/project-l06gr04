package org.example;

public class Golem extends Enemy{
    int id;
    public Golem(double speed, int totHP, int x, int y, int id){
        super(speed,totHP);
        this.id =id;

    }
}
