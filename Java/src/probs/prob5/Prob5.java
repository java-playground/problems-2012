package probs.prob5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob5 {

    public double p(double p0, double i, int n, int m) {

        if(m == 0) return p0;

        double j = i / 1200;
        double M = p0 * j / (1 - Math.pow(1+j, -n));

        double pLast = m == 1 ? p0 : p(p0, i, n,m-1);

        return pLast - (M - j * pLast);

    }

    public Prob5() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob5/Prob05.in.txt");
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String line = null;
            while((line = bf.readLine()) != null) {
                String[] inputs = line.split(" ");
                double p0 = Double.parseDouble(inputs[0]);
                double i = Double.parseDouble(inputs[1]);
                int n = Integer.parseInt(inputs[2]);
                int m = Integer.parseInt(inputs[3]);

                System.out.printf("%.2f%n", Math.abs(p(p0, i, n, m)));
            }

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
