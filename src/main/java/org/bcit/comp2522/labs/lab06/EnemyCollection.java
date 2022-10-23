package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyCollection<T> implements Iterable<T> {

  ArrayList<T> list;

  public EnemyCollection() {
    this.list = new ArrayList<T>();
  }

  public void add(T enemy) {
    this.list.add(enemy);
  }

  @Override
  public EnemyIterator<T> iterator() {
    return new EnemyIterator<T>(this.list);
  }
}
