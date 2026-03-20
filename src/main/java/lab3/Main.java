package lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path inputPath = Paths.get("in.txt");
        Path outputPath = Paths.get("out.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);
            List<String> modifiedLines = new ArrayList<>();

            System.out.println("--- Rezultat Procesare ---");

            for (String line : lines) {
                String processedLine = line + "\n";

                processedLine = processedLine.replace(".", ".\n");

                System.out.print(processedLine);

                modifiedLines.add(processedLine);
            }

            Files.write(outputPath, modifiedLines);
            System.out.println("\nRezultatul a fost salvat în out.txt");

        } catch (IOException e) {
            System.err.println("Eroare la manipularea fișierelor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}