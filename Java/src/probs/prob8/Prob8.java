package probs.prob8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob8 {

    public static void doTask(String input) {

        /*// replace spaces with dots
        String[] letters = input.replaceAll(" ", ".").split("");
        int length = letters.length;

           perimeter++;
        }

        String[] layout = new String[n][]
        for(int i = 0; i < length; i++) {

        }*/


    }

    public Prob8() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob8/Prob08.in.txt").toAbsolutePath();
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
