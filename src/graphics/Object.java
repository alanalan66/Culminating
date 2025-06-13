/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 *
 * @author 344165857
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Object {
    public int x, y;
    public PImage[] Images;
    public PApplet app;


        public Object(int x, int y){
        this.x = x;
        this.y = y;
        }
        
        public Object(PApplet p, int x, int y){
        this.app = p;
        this.x = x;
        this.y = y;
    }
        
    
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return x;
    }
    
    public PApplet getApp(){
        return app;
    }


    public void move (int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public void setApp(PApplet app){
        this.app = app;
    }
    
}