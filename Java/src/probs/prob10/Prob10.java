package probs.prob10;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Prob10 {

    public static void doTask(String input) {

        System.out.println(IntStream.rangeClosed(1, Integer.parseInt(input))
                .mapToObj(a -> BigInteger.valueOf(a))
                .reduce(BigInteger.valueOf(1), (a, b) -> a.multiply(b))
                .toString());

    }

    public Prob10() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob10/Prob10.in.txt").toAbsolutePath();
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

