package utils;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.net.http.HttpClient.newHttpClient;

public class Fetch {

    public static String getBody(int day, Boolean sample) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://adventofcode.com/2023/day/"+day+(sample?"":"/input")))
                .header("Cookie","session=YOUR-OWN-BROWSER-COOKIE")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assert response != null;

        if(sample) {
            int sampleStart = response.body().indexOf("<pre><code>")+11;
            int sampleEnd = response.body().indexOf("</code></pre>");
            return response.body().substring(sampleStart,sampleEnd);
    } else {
            return response.body();
        }

    }

    public static List<String> inputAsList(int day,boolean sample) {
        return Arrays.stream(getBody(day, sample).split("\\r?\\n")).toList();
    }

    public static char[][] inputAsChar2D(int day,boolean sample) {

        List<String> linesString = Arrays.stream(getBody(day, sample).split("\\r?\\n")).toList();
        List<char[]> linesCharList = new ArrayList<>();

        for(String line: linesString){
            char[] chars = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                chars[i] = line.charAt(i);
            }
            linesCharList.add(chars);
        }

        char[][] linesArr2D = new char[linesCharList.size()][];
        linesCharList.toArray(linesArr2D);

        return linesArr2D;
    }

    public static void main(String[] args) {
        System.out.println(inputAsList(1,true));
    }

}
