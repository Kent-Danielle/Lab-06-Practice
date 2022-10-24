package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;

public abstract class AbstractCharacter implements Comparable<AbstractCharacter>, ICollidable {
  protected PVector position;
  protected PVector direction;
  protected float diameter;
  protected Color color;
  protected Window window;
  protected float power;
  protected float speed = 1f;
  private final float maxDiameter = 100f;

  public AbstractCharacter(float power, PVector pin, PVector dir, float din, Color cin, Window win) {
    this.position = pin;
    this.direction = dir;
    this.power = power;
    this.diameter = din + power;
    this.color = cin;
    this.window = win;
  }

  @Override
  public int compareTo(AbstractCharacter c) {
    return (int) (this.power - c.power);
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

  @Override
  public boolean isCollided(ICollidable c) {
    if (c == this) {
      return false;
    }
    return c.getPosition().dist(this.position) <= (c.getDiameter() / 2f + this.diameter / 2f);
  }

  @Override
  public PVector getPosition() {
    return position;
  }

  public void powerGain(float powerGainRate) {
    this.power += powerGainRate;
    this.evolve();
  }

  public void evolve() {
    if (this.diameter <= maxDiameter) {
      this.diameter =  this.diameter + this.power;
    }
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

  @Override
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

  @Override
  public float getPower() { return power; }

  public void setPower(float power) { this.power = power; }
}
