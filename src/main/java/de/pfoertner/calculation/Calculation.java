package de.pfoertner.calculation;

import java.text.DecimalFormat;

public interface Calculation {

    DecimalFormat df = new DecimalFormat("#,###.##");
    String empty = "";

    void calculate();
    void calc();
}
