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
import endings.badEnd;


public class MySketch extends PApplet {
    private boolean badEndShown = false;
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
      @Override
    public void settings(){
	   //sets the size of the window
        size (800,400);
        backgroundImg = loadImage("images/background.png"); 

    }
    
    @Override
    public void setup(){
        background(255);
        person1 = new Character(this, 0, 280, characterIdle, characterWalk);
        fires = new ArrayList<Fire>();
        for (int i = 0; i < 10; i++) {
        int randomX = (int) random(50, width - 50);
        int randomStart = (int) random(0, 200);  // random start frame between 0 and 200
        fires.add(new Fire(this, randomX, 0, fire, randomStart));
        }
      }
    
        @Override
        public void draw(){

            background(backgroundImg);
            stroke(255, 0, 0);    // Red border color
            strokeWeight(5);      // Border thickness
            noFill();
            rect(0, 0, width, height);

            for (Fire f : fires) {
            f.drawFire();
            if (person1.isCollidingWith(f)) {
            // Teleport character to starting position
            person1.setX(0);
            person1.setY(280);
        }
    }
           person1.update();
            person1.drawCharacter();



           if (!badEndShown && person1.getX() + person1.getCurrentImage().width >= width) {
    badEndShown = true; // so this block runs only once
    new badEnd().setVisible(true);
    this.surface.setVisible(false);
    // Optionally call exit() to stop the sketch cleanly
    // this.exit();
}

        }


    
      @Override
    public void keyPressed() {
    person1.keyPressed();
}
  @Override
public void keyReleased() {
    person1.keyReleased();
}


}

    


      
   

    