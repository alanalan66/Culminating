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
import java.util.ArrayList;

public class MySketch extends PApplet {
    private Character person1;
    private ArrayList<Fire> fires;
    private PImage backgroundImg;
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
        backgroundImg = loadImage("images/background.png"); 

    }
    
    public void setup(){
	   //sets the background colour using R,G,B (https://rgbcolorpicker.com/)
        background(255);
        person1 = new Character(this, 0, 280, characterIdle, characterWalk);
        fires = new ArrayList<Fire>();
        for (int i = 0; i < 10; i++) {
        int randomX = (int) random(50, width - 50);
        int randomStart = (int) random(0, 200);  // random start frame between 0 and 200
        fires.add(new Fire(this, randomX, 0, fire, randomStart));
        }
      }
    
    
    public void draw(){

        background(backgroundImg);
        stroke(255, 0, 0);    // Red border color
        strokeWeight(5);      // Border thickness
        noFill();
        rect(0, 0, width, height);
        person1.update();
        person1.drawCharacter();
        for (Fire f : fires) {
        f.drawFire();
        }
    }
    
    
    
    public void keyPressed() {
    person1.keyPressed();
}

public void keyReleased() {
    person1.keyReleased();
}


}

    


      
   

    