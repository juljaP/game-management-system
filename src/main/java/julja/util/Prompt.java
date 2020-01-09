package julja.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  
  Scanner input;
  
  public Prompt(Scanner input) {
    this.input = input;
  }

  public String inputString(String label) {
    System.out.print(label);
    return input.nextLine();
  }
  
  public int inputInt(String label) {
    System.out.print(label);
    return Integer.parseInt(input.nextLine());
  }
  
  public Date inputDate(String label) {
    System.out.print(label);
    return Date.valueOf(input.nextLine());
  }
  
}
