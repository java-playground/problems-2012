package probs.prob4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Prob4 {

    public Prob4() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob4/Prob04.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            // get decoding key
            String key = bf.readLine();

            // decode lines
            String line = null;
            while((line = bf.readLine()) != null) {
                String[] words = Arrays.stream(line.split(" "))
                        .map(word -> {

                            String[] chars = word.split("-");
                            String result = "";
                            for(String ch : chars) {
                                result += key.substring(Integer.parseInt(ch)-1, Integer.parseInt(ch));
                            }
                            return result;

                        })
                        .toArray(String[]::new);

                System.out.println(String.join(" ", words));
            }

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
