package de.pfoertner;

import de.pfoertner.calculation.Audio;
import de.pfoertner.calculation.Picture;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Welcome to the Size Calculator!");
        System.out.println("In this program you can calculate the size of audio files like in school lessons.");
        System.out.println("You also can calculate the size of picture files.");
        System.out.println("All your results will be saved in a file called \"results.txt\" with the calculation way.");
        System.out.println("The language of the results will be in German.");
        System.out.println("Please enter the type of the file you want to calculate the size of.");
        System.out.println("You can choose between \"audio\" and \"picture\".");
        System.out.println("You can also use 1 for audio and 2 for picture.");
        System.out.print("Your choice: ");
        input = scanner.nextLine();
        if (input.equals("audio") || input.equals("1")) {
            Audio audio = new Audio();
            audio.calculate();
        } else if (input.equals("picture") || input.equals("2")) {
            Picture picture = new Picture();
            //picture.calculate();
            System.out.println("This feature is not implemented yet.");
        } else {
            System.out.println("You have to enter \"audio\" or \"picture\" or 1 or 2.");
            System.out.println("Please restart the program.");
        }
    }
}