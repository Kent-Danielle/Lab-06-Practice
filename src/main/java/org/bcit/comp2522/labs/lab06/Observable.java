package org.bcit.comp2522.labs.lab06;

public abstract class Observable {
  void registerObserver(Observer o) {};

  void deregisterObserver(Observer o) {};

  void notifyObservers() {};
}
