package julja.util;

import java.util.Arrays;

// empty, push, pop, clone
public class Stack<E> implements Cloneable{

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;

  public Stack() {
    elementData = new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  public void push(E value) {
    if (this.size == this.elementData.length) {
      int oldCapacity = this.elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }
    this.elementData[this.size++] = value;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if(empty()) {
      return null;
    }
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null;
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>) super.clone();
      Object[] arr = new Object[this.size];
      for (int i = 0 ; i < this.size ; i++) {
        arr[i] = this.elementData[i];
      }
      temp.elementData = arr; // 복제한 스택 객체가 새로 만든 배열 가리키도록 함
      return temp;
    } catch (CloneNotSupportedException e) {
      System.out.println(e);
      return null;
    }
  }
  
  public Iterator<E> iterator() {
    return new StackIterator<>(this);
  }
  
  static class StackIterator<T> implements Iterator<T> {
    
    Stack<T> stack;
    
    public StackIterator(Stack<T> stack) {
      this.stack = stack.clone();
    }

    public boolean hasNext() {
      return !stack.empty();
    }

    public T next() {
      return stack.pop();
    }

  }

}
