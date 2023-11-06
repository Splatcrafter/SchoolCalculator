package de.pfoertner.calculation;

import de.pfoertner.utils.FileSaver;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class represents an audio file.
 * It implements the Calculation interface to perform size calculations.
 *
 * @author Erik Pförtner
 * @see Calculation
 * @since 1.0
 */
public class Audio implements Calculation {

    /**
     * This variable represents the frequency in hertz (Hz).
     */
    private double hz;
    /**
     * Represents a private long variable called 'bit'.
     * This variable is used to store the bit of an audio file.
     */
    private long bit;
    /**
     * Represents the number of channels available.
     * <p>
     * Channels are used by audio files to let the user hear sounds from different directions.
     * For example, if you have a stereo audio file, you can hear sounds from the left and right.
     * </p>
     */
    private int channels;

    /**
     * This method is used to calculate the size of an audio file based on user input for
     * hz, bit, and channels.
     * The calculation results will be saved in a file called "results.txt".
     * The user is prompted for input values and validation is performed to ensure that valid
     * numeric values are provided.
     * If the user decides to start the calculation again, the method
     * recursively calls itself.
     */
    @Override
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen audio.");
        System.out.println("Please enter different values to calculate the size of your audio file.");
        System.out.println("First you have to enter the hz of your audio file.");
        System.out.print("Your hz: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your hz: ");
            scanner.next();
        }
        hz = scanner.nextDouble();
        System.out.println("Now you have to enter the bit of your audio file.");
        System.out.print("Your bit: ");
        while (!scanner.hasNextLong()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your bit: ");
            scanner.next();
        }
        bit = scanner.nextLong();
        System.out.println("Now you must enter the channels used by the audio file.");
        System.out.println("Like mono or stereo.");
        System.out.println("You must enter a number like 1 for mono or 2 for stereo.");
        System.out.print("Your channels: ");
        while (!scanner.hasNextInt()) {
            System.out.println("You have to enter a number.");
            System.out.print("Your channels: ");
            scanner.next();
        }
        channels = scanner.nextInt();
        System.out.println("Your hz: " + hz);
        System.out.println("Your bit: " + bit);
        System.out.println("Your channels: " + channels);
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
     * Calculates the size of an audio file based on user input of hz, bit, and channels.
     * Prompts the user to enter the required values and verifies the input.
     * If the user enters incorrect values, the process will restart.
     * Once the input is verified,
     * the calculation will start and the result will be saved in a file called "results.txt".
     */
    @Override
    public void calc() {
        double bps = hz * bit * channels;
        String bpsString = df.format(hz) + " Hz * " + df.format(bit) + " Bit pro Sample * " + df.format(channels) + (channels == 1 ? " Kanal" : " Kanäle") + " = " + df.format(bps) + " Bits pro Sek.";
        double bph = bps * 60 * 60;
        String bphString = df.format(bps) + " Bits pro Sek. * 60 Min. * 60 Sek. = " + df.format(bph) + " Bits pro Stunde";

        double byteph = bph / 8;
        String bytephString = df.format(bph) + " Bits pro Std. / 8 = " + df.format(byteph) + " Byte pro Std.";
        double kibiph = byteph / 1024;
        String kibiphString = df.format(byteph) + " Byte pro Std. / 1024 = " + df.format(kibiph) + " KiB pro Std.";
        double mibiph = kibiph / 1024;
        String mibiphString = df.format(kibiph) + " KiB pro Std. / 1024 = " + df.format(mibiph) + " MiB pro Std.";
        double gibiph = mibiph / 1024;
        String gibiphString = df.format(mibiph) + " MiB pro Std. / 1024 = " + gibiph + " GiB pro Std.";
        FileSaver.save(FileSaver.CalculationType.AUDIO,
                bpsString,
                empty,
                bphString,
                empty,
                bytephString,
                kibiphString,
                mibiphString,
                gibiphString
        );
    }
}
