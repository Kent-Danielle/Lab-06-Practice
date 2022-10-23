package org.bcit.comp2522.labs.lab06;

import java.awt.Color;
import processing.core.PVector;

public abstract class Observable extends AbstractCharacter {

  public Observable(PVector pin, PVector dir, float din, Color cin, Window win) {
    super(pin, dir, din, cin, win);
  }
  void registerObserver(Observer o) {}

  void unregisterObserver(Observer o) {}

  void notifyObservers() {}
}
