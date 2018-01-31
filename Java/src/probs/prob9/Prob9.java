package probs.prob9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Prob9 {

    public static boolean checkIfSimilar(String word1, String word2) {

        if(word1.length() != word2.length()) return false;

        AtomicInteger counter = new AtomicInteger(0);
        int incorrect = Arrays.stream(word1.split(""))
                .mapToInt(letter -> letter.toLowerCase().equals(word2.substring(counter.getAndIncrement(), counter.get()).toLowerCase()) ? 0 : 1)
                .sum();

        return incorrect == 1;

    }

    public static void doTask(String input) {

        String[] words = input.split(" ");

        Set<List<String>> matches = new HashSet<>();

        for(String word1: words) {
            for(String word2: words) {
                if(word1.equals(word2)) continue;

                if(checkIfSimilar(word1, word2)) {

                    if(word1.compareTo(word2) < 0) {
                        matches.add(Arrays.asList(word1, word2));
                    } else {
                        matches.add(Arrays.asList(word2, word1));
                    }

                }
            }
        }

        List<List<String>> sortedList = new ArrayList<List<String>>(matches);
        Collections.sort(sortedList, (a, b) -> {
            int compare = a.get(0).compareTo(b.get(0));
            if(compare != 0) return compare;
            else return a.get(1).compareTo(b.get(1));
        });
        for(List<String> match : sortedList) {
            System.out.printf("%s %s%n", match.get(0), match.get(1));
        }

    }

    public Prob9() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob9/Prob09.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String line = null;
            while((line = bf.readLine()) != null) {

                doTask(line);

            }

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}

