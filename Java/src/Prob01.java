import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob01 {

    public static void main(String[] args) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob1/Prob01.in.txt").toAbsolutePath();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

            // do stuff

            double total = 0;

            String line = null;
            while((line = reader.readLine()) != null) {

                // do something with line
                String[] parts = line.split("=");

                String currency = parts[0];
                int numberCoins = Integer.parseInt(parts[1]);

                if(currency.equals("HALFDOLLAR")) {
                    total += 0.5 * numberCoins;
                } else if(currency.equals("QUARTER")) {
                    total += 0.25 * numberCoins;
                } else if(currency.equals("DIME")) {
                    total += 0.1 * numberCoins;
                } else if(currency.equals("NICKEL")) {
                    total += 0.05 * numberCoins;
                } else if(currency.equals("PENNY")) {
                    total += 0.01 * numberCoins;
                }

            }

            System.out.printf("$%.2f", total);


        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
