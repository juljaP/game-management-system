package julja.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size = 0;
  public int size() {
    return this.size;
  } 

  public Iterator<E> iterator() {

    return new Iterator<E>() {
      List<E> list = (List<E>)AbstractList.this;
      int cursor;

      public boolean hasNext() {
        return list.size() > cursor;
      }

      public E next() {
        return list.get(cursor++);
      }
    };
  }

}
