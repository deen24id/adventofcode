package Day02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.Fetch;


public class Part2 {
    public static void main(String[] args) {

        List<String> input = Fetch.inputAsList(2, false);

        int count = 0;

        for (String game : input) {
            game = game.substring(game.indexOf(":") + 2);
            Map<String, Integer> limits = getLimits(game);

            int power = 1;
            for (int value : limits.values()) {
                power *= value;
            }

            count += power;
        }

        System.out.println(count);
    }

    private static Map<String, Integer> getLimits(String game) {
        String[] reveals = game.split("; ");

        Map<String, Integer> limits = new HashMap<>(
                Map.of("red", 0, "green", 0, "blue", 0)
        );

        for (String reveal : reveals) {
            String[] cubes = reveal.split(", ");

            for (String cube : cubes) {
                String[] pair = cube.split(" ");
                String key = pair[1];
                int value = Integer.parseInt(pair[0]);

                if (limits.get(key) < value) {
                    limits.put(key, value);
                }
            }
        }
        return limits;
    }
}
