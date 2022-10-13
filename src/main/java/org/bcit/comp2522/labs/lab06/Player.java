package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

public class Player extends Observable implements Comparable{
  private PVector position;

  public void move() {}

  public void draw() {}

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
