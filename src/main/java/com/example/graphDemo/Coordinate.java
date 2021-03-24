package com.example.graphDemo;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "coordinate")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int X_value;

    @NotNull
    private int Y_value;


    Coordinate( int Y_value){
        this.Y_value = Y_value;
    }

    public Coordinate() {

    }

    public int getX_value() {
        return X_value;
    }

    public void setX_value(int x_value) {
        X_value = x_value;
    }

    public int getY_value() {
        return Y_value;
    }

    public void setY_value(int y_value) {
        Y_value = y_value;
    }


}
