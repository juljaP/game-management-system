package julja.util;

public interface List<E> {
  
  void add(E e);
  E get(int idx);
  E set(int index, E e);
  E remove(int index) ;
  E[] toArray(E[] arr);
  Object[] toArray();
  int size();
  Iterator<E> iterator();

}
