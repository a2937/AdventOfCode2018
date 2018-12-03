package io.github.a2937.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader
{


    /**
     * Read values from file string.
     * Each value is on a new line.
     * @param fileLocation the file location
     * @return a string with the file contents.
     */
    public static String readValuesFromFile(String fileLocation)
    {
        StringBuilder fileContents = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileLocation)))
        {
            while(scanner.hasNextLine())
            {
                fileContents.append(scanner.nextLine()).append("\n");
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println(fileLocation + " not found.");
        }
        return fileContents.toString();
    }
}
