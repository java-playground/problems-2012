package CLASSPACKAGE;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CLASS_NAME {

    public static void doTask(String input) {

        // do stuff here

    }

    public CLASS() {

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