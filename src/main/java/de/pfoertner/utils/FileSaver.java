package de.pfoertner.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaver {

    private static final File FILE = new File("results.txt");
    public enum CalculationType {
        AUDIO, PICTURE
    }

    public static void save(CalculationType calculationType, String... results) {

        if (!FILE.exists()) {
            try {
                Path path = FILE.toPath();
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        boolean empty;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            empty = reader.readLine() == null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE, true))) {
            if (!empty) {
                writer.println();
                writer.println("--------------------");
                writer.println();
            }
            if (calculationType == CalculationType.AUDIO) {
                writer.println("Audio:");
            } else if (calculationType == CalculationType.PICTURE) {
                writer.println("Bilder:");
            }
            for (String result : results) {
                writer.println(result);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
