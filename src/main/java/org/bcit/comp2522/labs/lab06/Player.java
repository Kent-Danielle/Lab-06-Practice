package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Observable {
  private static Player player;

  private float powerGainRate = 0.2f;

  private Player(float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    super(power, pin, dir, din, cin, win);
  }
  private Player(float powerGain, float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    super(power, pin, dir, din, cin, win);
    this.powerGainRate = powerGain;
  }

  public static Player getInstance(float power, PVector playerPos, PVector playerDir, float charDiameter, Color playerColor, Window window) {
    if (player == null) {
      player = new Player(power, playerPos, playerDir, charDiameter, playerColor, window);
    }

    return player;
  }

  public void redirect(PVector pos) {
    PVector playerPos = this.position.copy();
    this.direction = pos.add(playerPos.mult(-1f)).normalize();
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
  public void registerObserver(Observer o) {}

  @Override
  public void unregisterObserver(Observer o) {}

  @Override
  public void notifyObservers() {

  }
}
