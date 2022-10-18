package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyCollection<Enemy> implements Iterable<Enemy>{

  ArrayList<Enemy> list;

  public EnemyCollection() {
    this.list = new ArrayList<>();
  }

  public void add(Enemy enemy) {
    this.list.add(enemy);
  }

  @Override
  public EnemyIterator<Enemy> iterator() {
    return new EnemyIterator(this.list);
  }
}
