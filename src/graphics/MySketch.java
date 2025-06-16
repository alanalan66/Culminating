/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

/**
 * MySketch is the main Processing sketch for the game.
 * It handles rendering the background, player character,
 * animated fire hazards, and manages win/lose conditions.
 * 
 * @author 344165857, Alan liu
 */
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import endings.badEnd;


public class MySketch extends PApplet {
   // Flag to track if the bad ending has already been shown
    private boolean badEndShown = false;

    // The main character in the game
    private Character person1;

    // List of fire hazards
    private ArrayList<Object> objects;

    // Background image for the sketch
    private PImage backgroundImg;

    // Whether to show additional information (currently unused)
    private boolean showInfo = false;

    // Image paths for character idle animation
    private String[] characterIdle = {
        "images/characterIdle1.png",
        "images/characterIdle2.png"
    };

    // Image paths for character walking animation
    // [0] = walking left, [1] = walking right
    private String[][] characterWalk = {
        {
            "images/characterWalkL1.png",
            "images/characterWalkL2.png",
            "images/characterWalkL3.png",
            "images/characterWalkL4.png",
            "images/characterWalkL5.png",
            "images/characterWalkL6.png"
        },
        {
            "images/characterWalkR1.png",
            "images/characterWalkR2.png",
            "images/characterWalkR3.png",
            "images/characterWalkR4.png",
            "images/characterWalkR5.png",
            "images/characterWalkR6.png"
        }
    };

    // Image paths for fire animation
    private String[] fire = {
        "images/fire1.png",
        "images/fire2.png",
        "images/fire3.png"
    };

    /**
     * Sets the size of the window and loads the background image.
     * Called once at the start of the sketch.
     */
    @Override
    public void settings() {
        size(800, 400);
        backgroundImg = loadImage("images/background.png");
    }

    /**
     * Called once when the program starts. 
     * Initializes the player character and places fires at random positions.
     */
    @Override
    public void setup() {

        background(255);
        objects = new ArrayList<Object>();

        person1 = new Character(this, 0, 280, characterIdle, characterWalk);
        objects.add(person1);

        for (int i = 0; i < 10; i++) {
            int randomX = (int) random(50, width - 50);
            int randomStart = (int) random(0, 200);
            objects.add(new Fire(this, randomX, 0, fire, randomStart));
        }
    }

    /**
     * Called continuously in a loop. 
     * Draws the background, border, fires, and character.
     * Checks for collisions and win/lose conditions.
     */
        @Override
        public void draw() {
           background(backgroundImg);
        stroke(255, 0, 0);
        strokeWeight(5);
        noFill();
        rect(0, 0, width, height);

        for (Object o : objects) {
            o.draw();

            // Collision check only between Character and Fire
            if (o instanceof Fire) {
                Fire f = (Fire) o;
                if (person1.isCollidingWith(f)) {
                    person1.setX(0);
                    person1.setY(280);
                }
            }
        }

        person1.update();

        if (!badEndShown && person1.getX() + person1.getCurrentImage().width >= width) {
            badEndShown = true;
            new badEnd().setVisible(true);
            this.surface.setVisible(false);
        }
    }

    /**
     * Called when a key is pressed.
     * Passes the event to the character for handling.
     */
    @Override
    public void keyPressed() {
        person1.keyPressed();
    }

    /**
     * Called when a key is released.
     * Passes the event to the character for handling.
     */
    @Override
    public void keyReleased() {
        person1.keyReleased();
    }
}

    


      
   

    