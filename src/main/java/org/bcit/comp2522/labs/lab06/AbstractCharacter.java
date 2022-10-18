package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;

public abstract class AbstractCharacter {
  protected PVector position;
  protected PVector direction;
  protected float diameter;
  protected Color color;
  protected Window window;

  protected float speed = 1f;

  public AbstractCharacter(PVector pin, PVector dir, float din, Color cin, Window win) {
    this.position = pin;
    this.direction = dir;
    this.diameter = din;
    this.color = cin;
    this.window = win;
  }

  public void move() {
    PVector multDir = this.direction.copy();
    this.position = this.position.add(multDir.mult(speed));
  }

  public void draw() {
    window.fill(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    borders();
    window.ellipse(this.position.x, this.position.y, diameter, diameter);
  }

  private void borders() {
    if (position.x < -diameter) {
      position.x = window.width + diameter;
    }
    if (position.y < -diameter) {
      position.y = window.height + diameter;
    }
    if (position.x > window.width + diameter) {
      position.x = -diameter;
    }
    if (position.y > window.height + diameter) {
      position.y = -diameter;
    }
  }

  public PVector getPosition() {
    return position;
  }

  public void setPosition(PVector position) {
    this.position = position;
  }

  public PVector getDirection() {
    return direction;
  }

  public void setDirection(PVector direction) {
    this.direction = direction;
  }

  public float getDiameter() {
    return diameter;
  }

  public void setDiameter(float diameter) {
    this.diameter = diameter;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

}
