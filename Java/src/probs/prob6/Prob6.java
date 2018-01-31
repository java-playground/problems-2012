package probs.prob6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob6 {

    public static void doTask(String input) {

        input = input.replaceAll("[^0-9a-zA-Z]", "");

        String[] chars = input.split("");

        for(int i = 0; i <= chars.length/2; i++) {
            if(!chars[i].toLowerCase().equals(chars[chars.length-i-1].toLowerCase())) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");

    }

    public Prob6() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob6/Prob06.in.txt").toAbsolutePath();
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
