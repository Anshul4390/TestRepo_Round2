package com.test.movies.imdb.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {


	public static void writeIntoFile(String string) {
		String filename = "src/test/resources/output.txt";
		try{
			FileWriter fw = new FileWriter(filename,true);
		    fw.write(string+"\n");
		    fw.close();
		}
		catch(IOException ex1){
			
		}
		
	}
}
