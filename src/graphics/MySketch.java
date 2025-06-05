/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 *
 * @author 344165857
 */
import java.io.File;
import processing.core.PApplet;

public class MySketch extends PApplet {
    private Person person1;
    private boolean showInfo = false; 
    private String [] characterIdle = {"images/characterIdle1.png", "images/characterIdle2.png"};
 
    
    public void settings(){
	   //sets the size of the window
        size (800,400);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255);
        person1 = new Person(this, 0, 200, characterIdle);

    }
    
    public void setImagePath(String file){
       File imageFile = new File(file);
    }
    
    public void draw(){
        background(255,255,255);
         person1.draw();
        if (keyPressed){
            if (keyCode == LEFT) {
          person1.move(-5, 0);
        } else if (keyCode == RIGHT) {
          person1.move(5, 0);
        } else if (keyCode == UP) {
          person1.move(0, -5);
        } else if (keyCode == DOWN) {
          person1.move(0, 5);
        }
        }

    }
}

      
   

    