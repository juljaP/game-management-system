package julja.util;

import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractList<E>{

  Node<E> first;
  Node<E> last;
  int size;

  static class Node<T> {
    T value;
    Node<T> next; 
  }

  public void add(E e) {
    Node<E> newNode = new Node<>();
    newNode.value = e;
    if(this.size == 0) {
      first = last = newNode;
    } else {
      last.next =  newNode;
      last = newNode;
    }
    this.size++;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= this.size) {
      return;
    }

    Node<E> newNode = new Node<>();
    newNode.value = value;

    Node<E> cursor = first;
    for(int i = 0 ; i < index - 1 ; i++) {
      cursor = cursor.next;
    }

    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Node<E> cursor = first;
    for(int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Node<E> cursor = first;
    for(int i = 0 ; i < index - 1 ; i++) {
      cursor = cursor.next;
    }
    Node<E> deletedNode = null;
    if(index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }
    deletedNode.next = null;
    this.size--;
    return deletedNode.value;
  }

  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    Node<E> cursor = first;
    for(int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    E oldValue = cursor.value;
    cursor.value = e;
    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr =  new Object[size];
    Node<E> cursor = first;
    for(int i = 0 ; i < this.size ; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
    Node<E> cursor = first;
    for(int i = 0 ; i < this.size ; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  public int size() {
    return this.size;
  }

}