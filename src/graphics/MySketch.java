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
    private Character person1;
    private Fire fire1;
    private boolean showInfo = false; 
    private String [] characterIdle = {"images/characterIdle1.png", "images/characterIdle2.png"};
    private String [][] characterWalk = {
            {"images/characterWalkL1.png",
            "images/characterWalkL2.png",
            "images/characterWalkL3.png",
            "images/characterWalkL4.png",
            "images/characterWalkL5.png",
            "images/characterWalkL6.png" }
            ,
            {"images/characterWalkR1.png",
            "images/characterWalkR2.png",
            "images/characterWalkR3.png",
            "images/characterWalkR4.png",
            "images/characterWalkR5.png",
            "images/characterWalkR6.png"}
        };
    private String [] fire = {"images/fire1.png","images/fire2.png","images/fire3.png"};
    
    public void settings(){
	   //sets the size of the window
        size (800,400);
    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255);
        person1 = new Character(this, 0, 200, characterIdle, characterWalk);
        fire1 = new Fire(this, 100, 0, fire); 
    }
    
    
    public void draw(){
        background(255,255,255);
        person1.update();
        person1.drawCharacter();
        fire1.drawFire();
    }
}

    


      
   

    