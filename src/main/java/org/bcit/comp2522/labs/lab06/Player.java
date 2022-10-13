package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.Color;

public class Player extends Observable implements Comparable, IDrawable{
  private static Player player;

  private final Color color = new Color(0, 200, 255);
  private PVector position;

  private PVector direction;

  private float diameter;

  private Window window;
  private Player(PVector pin, PVector din, float diameter, Window window) {
    this.position = pin;
    this.direction = din;
    this.diameter = diameter;
    this.window = window;
  }

  public static Player getInstance(PVector pin, PVector din, float diameter, Window window) {
    if (player == null) {
      return new Player(pin, din, diameter, window);
    }
    return player;
  }
  public static Player getInstance() {
    return player;
  }

  public void move() {}

  @Override
  public void draw() {
    window.fill(color.getRed(), color.getGreen(), color.getBlue());
    this.window.ellipse(position.x, position.y, diameter, diameter);
  }

  @Override
  public void registerObserver(Observer o) {}

  @Override
  public void deregisterObserver(Observer o) {}

  @Override
  public void notifyObservers() {}

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
