package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
  private EnemyCollection<Enemy> deadEnemies = new EnemyCollection<Enemy>();
  private ArrayList<AbstractCharacter> characters = new ArrayList<>();
  private ArrayList<ICollidable> collidables = new ArrayList<>();
  private Date lastPowerUptime;
  private int powerUpInterval = 1000;
  private boolean inGame = true;

  /**
   * Runs before applet starts.
   */
  public void setup() {
    // Init enemies
    Color enemyColor = new Color(255, 0, 0);
    for (int i = 0; i < numEnemies; i++) {
      PVector enemyPos = new PVector(random(width), random(height));
      PVector enemyDir = new PVector(random(-1f, 1f), random(-1f, 1f)).normalize();
      Enemy enemy = new Enemy(random(1,5), enemyPos, enemyDir, charDiameter, enemyColor, this);
      addEnemy(enemy);
    }
    lastPowerUptime = new Date();

    // Init player as Singleton
    float initPlayerPower = 3f;
    float initPlayerSpd = 1.5f;
    PVector playerPos = new PVector(width / 2f, height / 2f);
    PVector playerDir = new PVector(1, 1).normalize();
    Color playerColor = new Color(0, 255,255);
    Player player = Player.getInstance(initPlayerSpd, initPlayerPower, playerPos, playerDir, charDiameter, playerColor, this);
    addPlayer(player);
  }

  public void addPlayer(Player player) {
    this.player = player;
    characters.add(player);
    collidables.add(player);
  }

  public void addEnemy(Enemy enemy) {
    enemies.add(enemy);
    characters.add(enemy);
    collidables.add(enemy);
  }

  public void removeEnemy(Enemy enemy) {
    enemies.remove(enemy);
    characters.remove(enemy);
    collidables.remove(enemy);
  }

  public void addDeadEnemyQueue(Enemy enemy) {
    deadEnemies.add(enemy);
  }

  public void resetGame() {
    inGame = false;
  }

  private void resetWindow() {
    enemies.clear();
    characters.clear();
    deadEnemies.clear();
    collidables.clear();
    setup();
  }

  /**
   * Runs on each frame.
   */
  public void draw() {
    if (inGame) {
      background(0);
      for (Enemy d : deadEnemies) {
        removeEnemy(d);
      }
      deadEnemies.clear();

      Date now = new Date();
      if (now.getTime() - lastPowerUptime.getTime() > powerUpInterval) {
        lastPowerUptime = now;
        // TODO: Make up something so that the farther the enemy is on the iteration, the less power it receives
        for (Enemy e : enemies) {
          e.powerGain(0.1f);
        }
      }

      player.scanEnemies();
      player.notifyObservers();

      for (AbstractCharacter c : characters) {
        c.move();
        c.draw();
      }
      player.redirect(new PVector(mouseX, mouseY));

      for (ICollidable c : collidables) {
        if (player.isCollided(c)) {
          c.collideEffect(player);
          player.collideEffect(c);
        }
      }
    } else {
      resetWindow();
      inGame = true;
    }
  }

  public void settings() {
    size(640, 360);
  }

  public EnemyCollection<Enemy> getEnemies() {
    return enemies;
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