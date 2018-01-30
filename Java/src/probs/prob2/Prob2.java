package probs.prob2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob2 {

    public Prob2() {

        /*
            left has T times
            right has H heralds
            each has N houses
            times subscribers = T + N - H
            herald subscribers = H + N - T
            times - herald = 2T - 2H
         */

        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("Java/src/probs/prob2/Prob02.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(file,charset)) {
            String line;
            while((line = bf.readLine()) != null) {
                int t = Integer.parseInt(line.split(" ")[0]);
                int h = Integer.parseInt(line.split(" ")[1]);
                if(t - h != 0) {
                    System.out.printf("%s has %d more subscribers than %s.%n", (t-h > 0) ? "Times" : "Herald", Math.abs(2*t - 2*h), (t-h > 0) ? "Herald" : "Times");
                } else {
                    System.out.println("Times and Herald have the same number of subscribers.");
                }
            }
        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
