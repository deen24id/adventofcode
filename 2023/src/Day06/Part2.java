package Day06;

import utils.Fetch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {

        List<String> input = Fetch.inputAsList(6, false);

        List<String> timesTemp = new ArrayList<>(Arrays.stream(input.getFirst().split("\\s+")).toList());
        timesTemp.removeFirst();
        StringBuilder timeTemp = new StringBuilder();
        for (String elem : timesTemp) {
            timeTemp.append(elem);
        }
        long time = Long.parseLong(timeTemp.toString());

        List<String> distancesTemp = new ArrayList<>(Arrays.stream(input.getLast().split("\\s+")).toList());
        distancesTemp.removeFirst();
        StringBuilder distanceTemp = new StringBuilder();
        for (String elem : distancesTemp) {
            distanceTemp.append(elem);
        }
        long distance = Long.parseLong(distanceTemp.toString());

        long count = 0;
        for (long hold = 1; hold < time; hold++) {
            long dist = hold * (time - hold);
            if (dist > distance) {
                count++;
            }
        }

        System.out.println(count);
    }

}
