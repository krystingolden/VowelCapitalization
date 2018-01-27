package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileModifier {

    private ArrayList textFromFile = new ArrayList();
    private ArrayList modifiedTextFromFile = new ArrayList();


    public String determineFile() {
        //Prompt the user for the filename to read from
        System.out.println("Which file do you want to modify?");
        Scanner keyboard = new Scanner(System.in);

        //If the users entry is incorrect, prompt them again
        String choice = keyboard.next();
        while (!(choice.equalsIgnoreCase("vowels.txt"))) {
            System.out.println("Entry must be \"vowels.txt\"");
            System.out.println("Which file do you want to modify?");
            choice = keyboard.next();
        }
        return choice;
    }

    public void readInText(String choice) throws IOException {

        //Get the path to the file and open it
        try (BufferedReader br = Files.newBufferedReader(Paths.get(choice))) {
            String lineFromFile;
            //Until there are no more lines to read from the file, loop through and add them to the array list
            while ((lineFromFile = br.readLine()) != null) {
                textFromFile.add(lineFromFile);
            }

            //If there is an issue opening the file, it will throw a message
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public void modifyText() {

        int length;

        //As long as there are still lines to read from the array list, loop through and modify them
        for (length = 0; length < textFromFile.size(); length++) {
            String currentLine = textFromFile.get(length).toString();
            String modifiedLine = currentLine.toUpperCase();
            modifiedTextFromFile.add(modifiedLine);
        }

    }


    //Write out the modified text
    public void writeOutText() {

        //write out the original text
        System.out.println("This is the original text:");
        int length;

        for (length = 0; length < textFromFile.size(); length++) {
            String currentLine = textFromFile.get(length).toString();
            System.out.println(currentLine);
        }

        System.out.println("");
        System.out.println("This is the modified text:");
        for (length = 0; length < modifiedTextFromFile.size(); length++) {
            String currentLine = modifiedTextFromFile.get(length).toString();
            System.out.println(currentLine);
        }

    }
}
