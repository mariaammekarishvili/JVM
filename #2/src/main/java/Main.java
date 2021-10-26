import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Logger logger;
    private static File file;

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger = LogManager.getLogger(Main.class.getName());
        file = new File("src/main/resources/data.txt");

        // Start
        String readResult = readFile();
        List<Float> numbers = asFloatList(readResult);
        float result = getAverage(numbers);

        writeResult(result);
    }

    // Read text from file line by line
    private static String readFile() {
        StringBuilder result = new StringBuilder();
        try {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    result.append(scanner.nextLine()).append(" ");
                }
            } else {
                throw new IOException("File does not exists, make sure have file added in the src/main/resources as data.txt.");
            }
        } catch (IOException e) {
            logger.trace(e.getMessage());
        }

        logger.log(Priority.INFO, result);
        return result.toString();
    }

    // Takes an average result in float and appends at the end of the file
    private static void writeResult(float result) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.append("\n").append(String.valueOf(result));
            fileWriter.close();
        } catch (IOException e) {
            logger.trace(e.getMessage());
        }
    }

    // Takes String parameter, splits by spaces, converts each element to Float returns new list of floats
    private static List<Float> asFloatList(String numbers) {
        final ArrayList<Float> result = new ArrayList<>();
        for (String i : numbers.split(" ")) {
            try {
                result.add(Float.parseFloat(i));
            } catch (Exception e) {
                logger.trace(e.getMessage());
            }
        }
        return result;
    }

    // Takes list of floats and calculates average
    private static float getAverage(List<Float> numbers) {
        float result = 0f;
        for (float i : numbers)
            result += i;
        return result / numbers.size();
    }
}
