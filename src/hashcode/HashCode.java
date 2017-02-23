/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class HashCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        // Get the filename.
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        // Open the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        int lineNumber = 0;
        while (inputFile.hasNext()) {
            lineNumber++;
            
        }
    }

}
