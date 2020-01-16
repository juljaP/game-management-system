package julja.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size = 0;
  public int size() {
    return this.size;
  } 
  public Iterator<E> iterator() {
    
    class ListIterator<T> implements Iterator<T>{
      
      List<T> list;
      int cursor;
      
      @SuppressWarnings("unchecked")
      public ListIterator() {
        this.list = (List<T>)AbstractList.this;
      }
      
      public boolean hasNext() {
        return list.size() > cursor;
      }
      
      public T next() {
        return list.get(cursor++);
      }
    }
    
    return new ListIterator<>();
  }
  
}
