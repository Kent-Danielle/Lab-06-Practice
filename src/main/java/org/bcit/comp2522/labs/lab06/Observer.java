package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

import java.awt.*;

public class Observer extends AbstractCharacter{

  public Observer(PVector pin, PVector dir, float din, Color cin, Window win) {
    super(pin, dir, din, cin, win);
  }

    void update(Object msg) {};
}
