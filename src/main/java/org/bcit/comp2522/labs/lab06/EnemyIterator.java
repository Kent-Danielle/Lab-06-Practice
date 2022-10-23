package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Iterator;

public class EnemyIterator<T> implements Iterator<T> {

  ArrayList<T> list;

  int currIndex;

  public EnemyIterator(ArrayList<T> list) {
    this.list = list;
    this.list.sort(null);
    currIndex = 0;
    list.sort(null);
  }
  @Override
  public boolean hasNext() {
    return currIndex < list.size();
  }

  @Override
  public T next() {
    T temp = list.get(currIndex);
    this.currIndex++;
    return temp;
  }
}
