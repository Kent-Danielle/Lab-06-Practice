package org.bcit.comp2522.labs.lab06;

import processing.core.PVector;

public interface ICollidable {
  boolean isCollided(ICollidable c);
  void collideEffect(ICollidable c);
  PVector getPosition();
  float getDiameter();
  float getPower();
}
