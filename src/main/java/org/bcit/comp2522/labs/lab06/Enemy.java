package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

public class Enemy extends Observer implements Comparable{
  private PVector position;

  public void move() {}

  public void draw() {}

  @Override
  public void update(Object msg) {}

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
