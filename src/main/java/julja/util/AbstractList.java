package julja.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size = 0;
  public int size() {
    return this.size;
  }
  public Iterator<E> iterator() {
    return new ListIterator<>(this);
  }
  
  static class ListIterator<T> implements Iterator<T>{
    
    List<T> list;
    int cursor;
    
    public ListIterator(List<T> list) {
      this.list = list;
    }
    
    public boolean hasNext() {
      return list.size() > cursor;
    }
    
    public T next() {
      return list.get(cursor++);
    }

  }
}
