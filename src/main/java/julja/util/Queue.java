package julja.util;

// offer, poll, clone
public class Queue<E> extends LinkedList<Object> implements Cloneable { 

  public void offer(E value) {
    this.add(value);
  }

  public Object poll() {
    return this.remove(0);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for(int i = 0 ; i < this.size ; i++) {
      temp.offer((E) this.get(i));
    }
    return temp;
  }

}
