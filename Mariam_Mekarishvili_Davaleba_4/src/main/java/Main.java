import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static Logger log;
    private static ArrayList<String> names;
    private static HashMap<String, Integer> animals;

    public static void main(String[] args) {
        log = org.slf4j.LoggerFactory.getLogger("Main");
        names = new ArrayList<>();
        animals = new HashMap<>();

        // 3
        names.add("Mariami");
        names.add("Mari");
        names.add("Tatia");
        names.add("Giorgi");

        List<String> filteredList = names.stream().filter(str -> str.length() > 5).collect(Collectors.toList());
        filteredList.forEach(log::debug);

        // 5 (ანუ Start პროპაგანდა)
        animals.put("Platyceps Najadum", 1); // წენგოსფერი მცურავი
        animals.put("Dolichophis Schmidti", 5); // წითელმუცელა მცურავი
        animals.put("Macrovipera Lebetinus", 21); // გიურზა
        animals.put("Vipera Transcaucasiana", 7); // ცხვირრქოსანი გველგესლა

        Map<String, Integer> resultHashMap = animals.entrySet().stream()
                .filter(map -> filter(map.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        resultHashMap.forEach((key, value) -> log.info(key + ":  " + value));
    }

    private static boolean filter(int weight) {
        return weight > 20;
    }
}
