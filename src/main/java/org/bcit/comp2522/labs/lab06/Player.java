package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Observable {
  private static Player player;
  private float powerGainRate = 0.2f;
  private float broadcastRadius = 50f;
  private ArrayList<Observer> observers;

  public ArrayList<Observer> getObservers() {
    return observers;
  }

  private Player(float speed, float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    super(speed, power, pin, dir, din, cin, win);
    this.observers = new ArrayList<Observer>();
  }
  private Player(float speed, float powerGain, float bRadius, float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    super(speed, power, pin, dir, din, cin, win);
    this.powerGainRate = powerGain;
    this.broadcastRadius = bRadius;
    this.observers = new ArrayList<Observer>();
  }

  public static Player getInstance(float speed, float power, PVector playerPos, PVector playerDir, float charDiameter, Color playerColor, Window window) {
    if (player == null) {
      player = new Player(speed, power, playerPos, playerDir, charDiameter, playerColor, window);
    }

    return player;
  }

  public void redirect(PVector pos) {
    PVector playerPos = this.position.copy();
    this.direction = pos.add(playerPos.mult(-1f)).normalize();
  }

  public void scanEnemies() {
    for (Enemy e : window.getEnemies()) {
      if (this.position.dist(e.getPosition()) <= broadcastRadius + this.diameter / 2f) {
        registerObserver(e);
      } else {
        unregisterObserver(e);
      }
    }
  }

  @Override
  public void collideEffect(ICollidable c) {
    System.out.println(this.power + " " + c.getPower());
    if (this.power >= c.getPower()) {
      powerGain(powerGainRate);
    } else {
      window.resetGame();
    }
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void unregisterObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update(this.position.copy(), this.power);
    }
  }
}
