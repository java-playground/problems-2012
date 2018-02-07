package probs.prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob1 {

    public Prob1() {

        double total = 0;

        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("Java/src/probs/prob1/Prob01.in.txt").toAbsolutePath();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while((line = reader.readLine()) != null) {
                Pattern p = Pattern.compile("(\\w+)\\=(\\d+)");
                Matcher m = p.matcher(line);
                m.find();

                double weight = -1;
                switch(m.group(1)) {
                    case "QUARTER":
                        weight = .25;
                        break;
                    case "DIME":
                        weight = .1;
                        break;
                    case "NICKEL":
                        weight = 0.05;
                        break;
                    case "HALFDOLLAR":
                        weight = 0.5;
                        break;
                    case "PENNY":
                        weight = 0.01;
                        break;
                }
                if(weight != -1) {
                    total += weight * Integer.parseInt(m.group(2));
                }
            }
        } catch(IOException e) { }

        System.out.printf("$%.2f", total);

    }

}
