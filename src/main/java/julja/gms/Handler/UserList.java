package julja.gms.Handler;

import java.util.Arrays;
import julja.gms.domain.User;

public class UserList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0;
  private User[] list;
  
  public UserList() {
    list = new User[DEFAULT_CAPACITY];
  }

  public int getSize() {
    return size + 1;
  }

  public void add(User u) {
    if (this.list.length == this.size) {
      int oldC = this.list.length;
      int newC = oldC + (oldC >> 1);
      Arrays.copyOf(this.list, newC);
    }
    this.list[this.size++] = u;
  }

  public User[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  

}
