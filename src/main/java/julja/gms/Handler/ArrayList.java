package julja.gms.Handler;

import java.util.Arrays;

public class ArrayList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0;
  private Object[] list; 
  
  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }
  
  public int getSize() {
    return size + 1;
  }
  

  public void add(Object obj) {
    if (this.list.length == this.size) {
      int oldC = this.list.length;
      int newC = oldC + (oldC >> 1);
      Arrays.copyOf(this.list, newC);
    }
    this.list[this.size++] = obj;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public Object detail(int idx) {
    if (idx >= 0 && idx <this.size) {
      return this.list[idx];
    } else {
      return null;
    }
  }
}
