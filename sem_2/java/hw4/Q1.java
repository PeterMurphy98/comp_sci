package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {
   public static void main(String[] args) throws IOException {
      File f = new File(args[0]);
      if (!f.exists()) {
    	  System.out.format("File doesn't exist.");
		  return;
	  }
      FileReader fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);
      int c = 0;             
      int[] count = {0,1,0};
      while((c = br.read()) != -1){
    	  char character = (char) c;
    	  count[0] += 1;
    	  if (character == ' ') {
    		  count[1] += 1;
    	  }
    	  if (character == '\n'){
    		  count[2] += 1;
          }
      }
      br.close();
      System.out.format("%d characters\n%d words\n%d lines\n", count[0], count[1], count[2]);
   }
}