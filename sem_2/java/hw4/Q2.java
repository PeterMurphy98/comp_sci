package hw4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;


public class Q2 {
	public static void main(String args[]) throws IOException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd HH_mm_ss");
		String f_new = args[0]+formatter.format(date);
	    File f = new File(args[0]);
	    if (!f.exists()) {
	    	System.out.format("File doesn't exist.");
		    return;
	    }
	    File f2 = new File(f_new);
	    if (f2.exists()) throw new java.io.IOException("File already exists.");
	    if (f.renameTo(f2)) {
			System.out.format("Success. New file is %s", f_new);
	    }
	}
}
