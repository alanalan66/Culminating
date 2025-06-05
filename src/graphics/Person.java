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

public class Person {
    public int x, y;
    private PImage image;
    private PApplet app; 
    
    public Person(PApplet p, int x, int y, String [] imagePath){
        this.app = p;
        this.x = x;
        this.y = y;
       
       
    }
    
    public void move (int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public void draw(){
        app.image(image, x, y);
    }
    
    
  
}
