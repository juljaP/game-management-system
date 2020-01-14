package julja.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size = 0;
  public int getSize() {
    return this.size;
  }
  public abstract void add(E e);
  public abstract E get(int idx);
  public abstract E set(int index, E e);
  public abstract E remove(int index) ;
  public abstract E[] toArray(E[] arr);
  public abstract Object[] toArray();

}
