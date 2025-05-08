package Day04;

import utils.Fetch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {

        List<String> input = Fetch.inputAsList(4, false);

        List<Integer> countCards = new ArrayList<>(Collections.nCopies(input.size(), 1));
        for (int i = 0; i < input.size(); i++) {
            String elem = input.get(i);
            elem = elem.split(": ")[1].trim();
            int count = Utils.getCount(elem);

            int counter = 1;
            while (counter <= count) {
                countCards.set(i + counter, countCards.get(i + counter) + countCards.get(i));
                counter++;
            }
        }

        int totalCard = 0;
        for (int countCard : countCards) {
            totalCard += countCard;
        }
        System.out.println(totalCard);
    }

}
