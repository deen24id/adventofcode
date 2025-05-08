package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Import {
    public static String readAsPlainString(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static List<String> readAsList(final String filePath) {
        final List<String> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return linesList;
    }

    public static String[][] readAsArray(final String filePath) {
        final List<String[]> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert each character to a String and store in an array
                String[] chars = line.split("");
                linesList.add(chars);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Convert the list to a 2D String array
        String[][] linesArray = new String[linesList.size()][];
        linesList.toArray(linesArray);

        return linesArray;
    }

    public static char[][] readCharTable(final String filePath) {
        final List<char[]> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                char[] chars = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    chars[i] = line.charAt(i);
                }
                linesList.add(chars);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Convert the list to a 2D String array
        char[][] linesArray = new char[linesList.size()][];
        linesList.toArray(linesArray);

        return linesArray;
    }
}