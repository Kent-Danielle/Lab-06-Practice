package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyCollection<Enemy> implements Iterable<Enemy> {

  ArrayList<Enemy> list;

  public EnemyCollection() {
    this.list = new ArrayList<Enemy>();
  }

  public void add(Enemy enemy) {
    this.list.add(enemy);
  }

  public void remove(Enemy enemy) {
    this.list.remove(enemy);
  }

  public void clear() {
    this.list.clear();
  }

  public int length() {return this.list.size();}

  @Override
  public EnemyIterator<Enemy> iterator() {
    return new EnemyIterator<Enemy>(this.list);
  }
}
