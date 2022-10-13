package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;
import processing.core.PVector;

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
  private final int numEnemies = 10;
  private final float charDiameter = 10f;
  private Player player;

  private EnemyCollection<Enemy> Enemies;
  private ArrayList<IDrawable> drawables = new ArrayList<>();





  /**
   * Runs before applet starts.
   */
  public void setup() {
    // Init player as Singleton
    PVector playerPos = new PVector(width / 2f, height / 2f);
    PVector playerDir = new PVector(1, 1).normalize();
    player = Player.getInstance(playerPos, playerDir, charDiameter, this);
    addDrawable(player);


    // Init enemies
    for (int i = 0; i < numEnemies; i++) {
      PVector enemyPos = new PVector(random(width), random(height));
      PVector enemyDir = new PVector(random(-1f, 1f), random(-1f, 1f)).normalize();
      Enemy enemy = new Enemy(enemyPos, enemyDir, charDiameter, this);
      addDrawable(enemy);
    }
  }

  /**
   * Runs on each frame.
   */
  public void draw() {
    background(0);
    for (IDrawable d : drawables) {
      d.draw();
    }
  }

  public void settings() {
    size(640, 360);
  }

  public void addDrawable(IDrawable d) {
    drawables.add(d);
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