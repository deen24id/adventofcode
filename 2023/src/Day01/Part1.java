package Day01;

import java.util.List;

import utils.Fetch;

public class Part1 {

    public static void main(String[] args) {

        List<String> input = Fetch.inputAsList(1, false);

        int count = 0;

        for (String elem : input) {
            String digits = elem.replaceAll("[a-z]", "");
            count += Integer.parseInt("" + digits.charAt(0) + digits.charAt(digits.length() - 1));
        }

        System.out.println(count);

    }
}