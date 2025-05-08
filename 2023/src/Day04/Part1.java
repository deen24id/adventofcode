package Day04;

import utils.Fetch;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {

        List<String> input = Fetch.inputAsList(4, false);

        int point = 0;
        for (String elem : input) {
            elem = elem.split(": ")[1].trim();
            int count = Utils.getCount(elem);

            if (count > 0) {
                point += (int) Math.pow(2, count - 1);
            }
        }
        System.out.println(point);
    }

}
