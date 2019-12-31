package julja.gms.Handler;

import java.util.Arrays;
import julja.gms.domain.Board;

public class BoardList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0;
  private Board[] list; 
  
  public BoardList() {
    list = new Board[DEFAULT_CAPACITY];
  }
  
  public BoardList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Board[DEFAULT_CAPACITY];
    else
      this.list = new Board[capacity];
  }

  public int getSize() {
    return size + 1;
  }

  public void add(Board b) {
    if (this.list.length == this.size) {
      int oldC = this.list.length;
      int newC = oldC + (oldC >> 1);
      Arrays.copyOf(this.list, newC);
    }
    this.list[this.size++] = b;
  }

  public Board[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public Board detail(int num) {
    for (int i = 0 ; i < this.size ; i++) {
      if (this.list[i].getBbsNum() == num) {
        return this.list[i];
      }
    }
    return null;
  }
}
