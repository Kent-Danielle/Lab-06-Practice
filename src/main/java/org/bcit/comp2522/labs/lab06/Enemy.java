package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.Color;

public class Enemy extends Observer implements Comparable, IDrawable{
  private final Color color = new Color(255, 0, 0);
  private PVector position;

  private PVector direction;
  private float diameter;
  private Window window;

  public Enemy(PVector pin, PVector din, float diameter, Window window) {
    this.position = pin;
    this.direction = din;
    this.diameter = diameter;
    this.window = window;
  }

  public void move() {}
  @Override
  public void draw() {
    window.fill(color.getRed(), color.getGreen(), color.getBlue());
    this.window.rect(position.x, position.y, diameter, diameter);
  }

  @Override
  public void update(Object msg) {}

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
