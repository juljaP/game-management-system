package julja.gms.Handler;

import java.util.Arrays;
import julja.gms.domain.Game;

public class GameList {
  
  private final int DEFALUT_CAPASITY = 100;
  private int size = 0;
  private Game[] list;
  
  public GameList() {
    list = new Game[DEFALUT_CAPASITY];
  }

  public void add(Game g) {
    if (this.size == this.list.length) {
      int oldC = this.list.length;
      int newC = oldC + (oldC >> 1);
      this.list = Arrays.copyOf(this.list, newC);
    }
    this.list[this.size++] = g;
  }

  public Game[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  

}
