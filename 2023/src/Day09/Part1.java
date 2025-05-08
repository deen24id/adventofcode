package Day09;

import utils.Fetch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        List<String> inputTemp = Fetch.inputAsList(9, false);

        List<List<Integer>> input = new ArrayList<>(inputTemp.size());
        for (String elem : inputTemp) {
            input.add(new ArrayList<>(Arrays.stream(elem.split("\\s")).map(Integer::parseInt).toList()));
        }

        int count = 0;
        for (List<Integer> elem : input) {
            count += Utils.getExtra(elem);
        }

        System.out.println(count);
    }
}
