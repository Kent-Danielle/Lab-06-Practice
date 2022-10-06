package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;


/**
 * Flocking: An implementation of Craig Reynold's Boids program to
 * simulate the flocking behavior of birds. Each boid steers itself
 * based on rules of avoidance, alignment, and coherence.
 *
 * @author Daniel Shiffman, extended and refactored by paul_bucci
 * @version 1.0
 */
public class Window extends PApplet {
  /**
   * Runs before applet starts.
   */
  public void setup() {
  }

  /**
   * Runs on each frame.
   */
  public void draw() {
    background(0);
  }

  public void settings() {
    size(640, 360);
  }


  /**
   * Main function.
   *
   * @param passedArgs arguments from command line
   */
  public static void main(String[] passedArgs) {
    String[] appletArgs = new String[]{"window"};
    Window window = new Window();
    PApplet.runSketch(appletArgs, window);
  }
}