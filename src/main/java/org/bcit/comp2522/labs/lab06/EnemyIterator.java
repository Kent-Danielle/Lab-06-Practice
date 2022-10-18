package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class EnemyIterator<T> implements Iterator {

  ArrayList<Enemy> list;

  int currIndex;

  public EnemyIterator(ArrayList<Enemy> list) {
    this.list = list;
    currIndex = 0;
  }

  @Override
  public boolean hasNext() {
    return 0 < list.size();
  }

  @Override
  public Enemy next() {
    int temp = currIndex;
    this.currIndex++;
    return list.get(temp);
  }
}
