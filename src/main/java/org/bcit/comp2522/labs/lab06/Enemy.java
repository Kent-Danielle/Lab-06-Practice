package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

public class Enemy extends Observer {

  private float distanceFromSource;

  public Enemy(float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    super(power, pin, dir, din, cin, win);
  }

  public void avoidPlayer(PVector pos){
    PVector enemyPos = this.position.copy();
    this.direction = (pos.add(enemyPos.mult(-1f)).mult(-1f)).normalize();
  }

  public void chasePlayer(PVector pos) {
    PVector enemyPos = this.position.copy();
    this.direction = pos.add(enemyPos.mult(-1f)).normalize();
  }

  public void updateDistanceMetric(AbstractCharacter c) {
    PVector sourcePos = c.getPosition().copy();
    this.distanceFromSource = sourcePos.dist(this.position) - (this.diameter / 2f) - (c.getDiameter() / 2f);
  }

  public float getDistanceFromSource() {
    return distanceFromSource;
  }

  @Override
  public void update(PVector p, float power) {
    System.out.println("Enemy " + this.power + " | Player " + power);
    if (power >= this.power) {
      avoidPlayer(p);
    } else {
      chasePlayer(p);
    }
  };

  @Override
  public void collideEffect(ICollidable c) {
    if (c instanceof Player && c.getPower() > this.power) {
      window.addDeadEnemyQueue(this);
    }
  }
}
