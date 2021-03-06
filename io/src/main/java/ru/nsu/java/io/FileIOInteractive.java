package ru.nsu.java.io;

import java.io.*;
import java.net.*;
import org.apache.commons.io.*;

public class FileIOInteractive {
    public static void main(String[] args) {
		File file = new File("java.html");
		if (file.exists()) {
			System.out.println(
					"Remove existing file " 
					+ file.getAbsolutePath() + " [y/n]?");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));
                if (!reader.readLine().toLowerCase().equals("y")) {
                    System.out.println("Exiting");
                    return;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
		}
		
		try (
            InputStream input = 
                    new URL("http://java.com/").openStream();
            OutputStream output = 
                    new FileOutputStream(file);
		) {
            IOUtils.copy(input, output);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
}
