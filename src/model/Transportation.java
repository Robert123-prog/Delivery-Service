package model;

import java.lang.annotation.Target;

public abstract class Transportation implements HasID{
    private int capacity;
    private Transportation_Type transportationType;

    public Transportation(int capacity, Transportation_Type transportation_type){
        this.capacity = capacity;
        this.transportationType = transportation_type;
    }

}
