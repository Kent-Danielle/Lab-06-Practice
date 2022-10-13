package org.bcit.comp2522.labs.lab06;

import java.util.Iterator;

public class EnemyCollection<Enemies> implements Iterable{
  @Override
  public EnemyIterator iterator() {
    return new EnemyIterator();
  }
}
