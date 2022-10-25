package org.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class EnemyIterator<Enemy> implements Iterator<Enemy> {

  ArrayList<Enemy> list;

  int currIndex;

  public EnemyIterator(ArrayList<Enemy> list) {
    this.list = list;
    Collections.sort(list, new Comparator<Enemy>() {
      @Override
      public int compare(Enemy o1, Enemy o2) {
        org.bcit.comp2522.labs.lab06.Enemy e1 = (org.bcit.comp2522.labs.lab06.Enemy) o1;
        org.bcit.comp2522.labs.lab06.Enemy e2 = (org.bcit.comp2522.labs.lab06.Enemy) o2;
        return (int) (e1.getDistanceFromSource() - e2.getDistanceFromSource());
      }
    });
    currIndex = 0;
    list.sort(null);
  }
  @Override
  public boolean hasNext() {
    return currIndex < list.size();
  }

  @Override
  public Enemy next() {
    Enemy temp = (Enemy) list.get(currIndex);
    this.currIndex++;
    return temp;
  }
}
