package com.pluralsight;

public class Main {

        /*
    https://programmingbydoing.com/
    Vowel capitalization - Assignment #137
     */

    public static void main(String[] args) throws Exception{

        FileModifier vowelFile = new FileModifier();
        //Read in a file as entered by the user
        String choice = vowelFile.determineFile();

        //Store the content
        vowelFile.readInText(choice);

        //Modify the content to upper case
        vowelFile.modifyText();

        //print out a modified version of the text
        vowelFile.writeOutText();
    }
}
