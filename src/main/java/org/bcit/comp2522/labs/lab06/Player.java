package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;

public class Player extends Observable {

  private static Player player;

  private Player(PVector pin, PVector dir, float din, Color cin, Window win) {
    super(pin, dir, din, cin, win);
  }

  public static Player getInstance(PVector playerPos, PVector playerDir, float charDiameter, Color playerColor, Window window) {
    if (player == null) {
      player = new Player(playerPos, playerDir, charDiameter, playerColor, window);
    }

    return player;
  }

  public void redirect() {
    PVector mousePos = new PVector(this.window.mouseX, this.window.mouseY);
    PVector playerPos = new PVector(this.position.x, this.position.y);
    this.direction = mousePos.add(playerPos.mult(-1f)).normalize();
  }

  @Override
  public void collideEffect(ICollidable c) {
    if (this.power >= c.getPower()) {
      // increase size
    } else {
      // reset game
    }
  }

  public void registerObserver(Observer o) {}

  public void unregisterObserver(Observer o) {}

  public void notifyObservers() {}
}
