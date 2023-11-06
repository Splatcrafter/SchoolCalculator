package de.pfoertner.calculation;

import de.pfoertner.utils.FileSaver;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Represents a picture object and provides methods for calculating the size of a picture file.
 * <p>
 * The Picture class implements the Calculation interface.
 * </p>
 *
 * @author Erik Pförtner
 * @see Calculation
 * @since 1.0
 */
public class Picture implements Calculation {

    /**
     * Represents the width value in centimeters.
     */
    private double widthCm;
    /**
     * Represents the height of an object in centimeters.
     * <p>
     * The height value is stored as a double precision floating point number,
     * allowing for both whole numbers and decimal values.
     * </p>
     */
    private double heightCm;
    /**
     * Represents the dots per inch (DPI) value.
     * <p>
     * DPI is a measure of the number of dots (pixels) that can be displayed or printed per inch.
     * This variable stores a double value representing the DPI.
     */
    private double dpi;
    /**
     * Represents a private variable "bit" of type double.
     *
     * <p>
     * The "bit" variable holds a double value.
     * </p>
     *
     * <p>
     * Note: This variable is marked as private, meaning it can only be accessed within the class it is declared in.
     * </p>
     */
    private double bit;

    /**
     * This method calculates the size of a picture file based on user input of width, height, dpi, and bit.
     * The calculation is saved in a file called "results.txt".
     * <p>
     * It prompts the user to enter the width in cm of the picture, followed by the height, dpi, and bit.
     * It validates each input to ensure that the user enters a number.
     * If any input is invalid, it prompts the user again for the correct input.
     * <p>
     * After all inputs are received and validated, it displays the user's inputs and asks if they are correct.
     * If the user answers "N" or "n", the process starts again.
     * <p>
     * Once all inputs are confirmed as correct, the calculation begins and the user is asked to wait.
     * The result is then saved in a file called "results.txt".
     */
    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen picture.");
        System.out.println("Please enter different values to calculate the size of your picture file.");
        System.out.println("First you have to enter the width in cm of your picture.");
        System.out.print("Your width: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your width: ");
            scanner.next();
        }
        widthCm = scanner.nextDouble();
        System.out.println("Now you have to enter the height in cm of your picture.");
        System.out.print("Your height: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your height: ");
            scanner.next();
        }
        heightCm = scanner.nextDouble();
        System.out.println("Now you have to enter the dpi of your picture.");
        System.out.print("Your dpi: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your dpi: ");
            scanner.next();
        }
        dpi = scanner.nextDouble();
        System.out.println("Now you have to enter the bit of your picture.");
        System.out.print("Your bit: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your bit: ");
            scanner.next();
        }
        bit = scanner.nextDouble();
        System.out.println("Your width: " + widthCm);
        System.out.println("Your height: " + heightCm);
        System.out.println("Your dpi: " + dpi);
        System.out.println("Your bit: " + bit);
        System.out.println("Is this correct?");
        System.out.println("The calculation will start in one step if right. (Y/n)");
        System.out.print("Your choice: ");
        while (!scanner.hasNext()) {
            System.out.println("You have to enter a letter.");
            System.out.print("Your choice: ");
            scanner.next();
        }
        String input = scanner.next();
        if (input.equals("N") || input.equals("n")) {
            System.out.println("The process will start again.");
            calculate();
            return;
        }
        System.out.println("The calculation will start now.");
        System.out.println("Please wait.");
        System.out.println("The calculation will be saved in a file called \"results.txt\".");
        calc();
    }

    /**
     * Calculates the size of a picture file based on user input.
     * Prompts the user to enter the width, height, dpi, and bit of the picture,
     * and then proceeds to calculate and save the file size in various units.
     */
    @Override
    public void calc() {
        double inchWidth = widthCm / 2.54;
        String inchWidthString = widthCm + " cm / 2.54 = " + df.format(inchWidth) + " Inch";
        double inchHeight = heightCm / 2.54;
        String inchHeightString = heightCm + " cm / 2.54 = " + df.format(inchHeight) + " Inch";

        double pixelPP = inchWidth * dpi * inchHeight * dpi;
        String pixelPPString = df.format(inchWidth) + " Inch * " + df.format(dpi) + " dpi * " + df.format(inchHeight) + " Inch * " + df.format(dpi) + " dpi = " + df.format(pixelPP) + " Pixel pro Bild";

        double bitPP = pixelPP * bit;
        String bitPPString = df.format(pixelPP) + " Pixel pro Bild * " + df.format(bit) + " Bit pro Pixel = " + df.format(bitPP) + " Bit pro Bild";

        double bytePP = bitPP / 8;
        String bytePPString = df.format(bitPP) + " Bit pro Bild / 8 = " + df.format(bytePP) + " Byte pro Bild";
        double kbPP = bytePP / 1024;
        String kibPPString = df.format(bytePP) + " Byte pro Bild / 1024 = " + df.format(kbPP) + " KiB pro Bild";
        double mibPP = kbPP / 1024;
        String mibPPString = df.format(kbPP) + " KiB pro Bild / 1024 = " + df.format(mibPP) + " MiB pro Bild";
        double gibPP = mibPP / 1024;
        String gibPPString = df.format(mibPP) + " MiB pro Bild / 1024 = " + df.format(gibPP) + " GiB pro Bild";

        FileSaver.save(FileSaver.CalculationType.PICTURE,
                inchWidthString,
                inchHeightString,
                empty,
                pixelPPString,
                empty,
                bitPPString,
                empty,
                bytePPString,
                kibPPString,
                mibPPString,
                gibPPString
        );
    }
}
