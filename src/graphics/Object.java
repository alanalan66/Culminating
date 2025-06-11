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
    private PImage[] Images;
    private PApplet app;


        public Object(PApplet p, int x, int y){
        this.app = p;
        this.x = x;
        this.y = y;

    }
    public Object(PApplet p, int x, int y, String[] Path){
        this.app = p;
        this.x = x;
        this.y = y;

        Images = new PImage[Path.length];
        for (int i = 0; i < Path.length; i++) {
            Images[i] = app.loadImage(Path[i]);
        }
        
    }


    public void move (int dx, int dy){
        x += dx;
        y += dy;
    }

    
}