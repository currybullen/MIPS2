package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class used to parse lines from a file.
 * @author c12mkn
 *
 */
public class FileParser {
    private BufferedReader reader;

    /**
     * Constructs a FileParser object, exits if not possible.
     * @param fileName the name of the file to parse.
     */
    public FileParser(String fileName) {
        try {
            File file = new File(fileName);
            reader = new BufferedReader(new FileReader(file));
        } catch (NullPointerException | FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(1);
        }
    }

    /**
     * Returns the next line of the file, exits if not possible.
     * @return the next line of the file.
     */
    public String nextLine() {
        String ret = null;
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading from file.");
            System.exit(2);
        }

        return ret;
    }
}
