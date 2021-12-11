import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.io.*;

public class minFind {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void minNumb() {
        try {
            Scanner file = new Scanner(new File("src/main/resources/data3.txt"));
            float smallest = file.nextFloat();

            while (file.hasNextInt()) {
                float num = file.nextFloat();

                if (num < smallest) {
                    smallest = num;
                }

                System.out.println(num);
            }
            BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/data3.txt",true));
            br.write("\n"+ "smallest Num is: " + smallest);
            br.close();
            file.close();

            System.out.println("In the file the smallest numb is: " + smallest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.error("Error during reading system input", e);
        }

    }

}
