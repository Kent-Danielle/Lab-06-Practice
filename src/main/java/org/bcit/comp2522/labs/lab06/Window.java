package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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

  private EnemyCollection<Enemy> enemies = new EnemyCollection<Enemy>();

  private ArrayList<AbstractCharacter> characters = new ArrayList<>();

  /**
   * Runs before applet starts.
   */
  public void setup() {
    // Init player as Singleton
    PVector playerPos = new PVector(width / 2f, height / 2f);
    PVector playerDir = new PVector(1, 1).normalize();
    Color playerColor = new Color(0, 255,255);
    Player player = Player.getInstance(playerPos, playerDir, charDiameter, playerColor, this);
    addPlayer(player);


    // Init enemies
    Color enemyColor = new Color(255, 0, 0);
    for (int i = 0; i < numEnemies; i++) {
      PVector enemyPos = new PVector(random(width), random(height));
      PVector enemyDir = new PVector(random(-1f, 1f), random(-1f, 1f)).normalize();
      Enemy enemy = new Enemy(enemyPos, enemyDir, charDiameter, enemyColor, this);
      enemy.setPower(random(1,10));
      addEnemy(enemy);
    }
  }

  public void addPlayer(Player player) {
    this.player = player;
    characters.add(player);
  }

  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
    characters.add(enemy);
  }

  /**
   * Runs on each frame.
   */
  public void draw() {
    background(0);
    for (AbstractCharacter c : characters) {
      c.move();
      c.draw();
    }
    player.redirect();
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