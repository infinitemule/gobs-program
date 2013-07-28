package com.infinitemule.gobs.program;

import java.io.IOException;

/**
 * Unfortunately because the way System.out and System.in
 * work, you can't just read one character, you have to
 * press Enter.
 */
public class Console {
    
  private static final String PENUS = "Penus Penus Penus Penus Penus Penus";
  
  public static void main(String[] args) {
    
    System.out.print("Gob's Program: Y/N?\n? ");
    
    try {
      System.in.read();
    }
    catch(IOException e) {
      System.exit(1);
    }
    
    while(true) {
      System.out.println(PENUS);
    }
    
  }
  
}
