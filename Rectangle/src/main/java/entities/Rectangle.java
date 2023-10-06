/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package entities;

/**
 *
 * @author Denilson
 */
public class Rectangle {
    private double width, height;
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double getWidth(){
        return width;
    }
    public void setWidth(double w){
        this.width = w;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double h){
        this.height = h;
    }
    public double area(){
        return width*height;
    }
    public double perimeter(){
        return 2*(width+height);
    }
    public double diagonal(){
        return Math.sqrt((Math.pow(width, 2) + Math.pow(height, 2)));
    }

}
