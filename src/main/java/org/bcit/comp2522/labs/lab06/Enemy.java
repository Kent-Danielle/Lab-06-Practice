package org.bcit.comp2522.labs.lab06;

import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

public class Enemy extends Observer implements Comparable{

  public Enemy(PVector pin, PVector dir, float din, Color cin, Window win) {
    super(pin, dir, din, cin, win);
  }

  public void update(Object msg) {};

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
