package julja.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size = 0;
  public int size() {
    return this.size;
  }
  public Iterator<E> iterator() {
    return new ListIterator<>(this);
  }
}
