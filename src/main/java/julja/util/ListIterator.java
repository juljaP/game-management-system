package julja.util;

public class ListIterator<E> implements Iterator<E>{
  
  List<E> list;
  int cursor;
  
  public ListIterator(List<E> list) {
    this.list = list;
  }
  
  public boolean hasNext() {
    return list.size() > cursor;
  }
  
  public E next() {
    return list.get(cursor++);
  }

}
