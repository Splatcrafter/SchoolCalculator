package de.pfoertner.calculation;

import java.text.DecimalFormat;

/**
 * The Calculation interface represents a calculation that can be performed.
 * It provides methods for performing calculations and formatting numbers.
 *
 * <p>
 * The Calculation interface includes a variable for number formatting and an empty string constant.
 * It also includes methods for performing calculations and operations.
 * </p>
 *
 * <p>
 * The Calculation interface does not provide any example code.
 * </p>
 *
 * @author Erik Pförtner
 * @see DecimalFormat
 * @since 1.0
 */
public interface Calculation {

    /**
     * This variable is an instance of the DecimalFormat class used for number formatting.
     * The pattern used is "#,###.##",
     * which formats numbers in the thousands with commas and displays up to two decimal places.
     * It is commonly used to format decimal numbers for display purposes.
     *
     * @see DecimalFormat
     */
    DecimalFormat df = new DecimalFormat("#,###.##");
    /**
     * Represents an empty string.
     *
     * <p>
     * The {@code empty} variable is used to store an empty string value.
     * It is initialized with an empty string literal, represented by ""
     * </p>
     *
     * <p>
     * Empty strings are widely used in programming to represent a string with no characters.
     * </p>
     *
     * @since 1.0
     */
    String empty = "";

    /**
     * Calculates and performs the necessary operations based on the given input.
     */
    void calculate();

    /**
     * Calculates the result of a specific operation.
     */
    void calc();
}
