package julja.util;

// offer, poll, clone
public class Queue<E> extends LinkedList<E> implements Cloneable { 

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }

  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for(int i = 0 ; i < this.size ; i++) {
      temp.offer((E) this.get(i));
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
    return this.new QueueIterator<>();
  }
  
    class QueueIterator<T> implements Iterator<T> {
    
    Queue<T> queue;
    
    @SuppressWarnings("unchecked")
    public QueueIterator() {
      this.queue = (Queue<T>) Queue.this.clone();
    }

    public boolean hasNext() {
      return queue.size > 0;
    }

    public T next() {
      return queue.poll();
    }

  }

}
