package com.board.model;

/* 
 * This class represents a message for drawing operations on the board.
 */
public class DrawMessage {

    private double x; // X coordinate of the drawing action
    private double y; // Y coordinate of the drawing action
    private String color; // Color used for drawing
    private String type; // DRAW, ERASE, etc.  
    
    // empty constructor for spring
    public DrawMessage() {
    }

    //Getter and Setter methods
    public double getX(){ 
        return x; 
    }

    public void setX(double x){ 
        this.x = x; 
    }

    public double getY(){ 
        return y; 
    }

    public void setY(double y) { 
        this.y = y; 
    }

    public String getColor() { 
        return color; 
    }

    public void setColor(String color){ 
        this.color = color; 
    }

    public String getType(){ 
        return type; 
    }

    public void setType(String type){ 
        this.type = type; 
    }
}   
