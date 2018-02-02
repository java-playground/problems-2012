package probs.prob11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob11 {

    static int[][] map;

    public static void doTask(String input) {

        String[] data = input.split(",");

        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        int value = Integer.parseInt(data[2]);

        map[x-1][y-1] = value;

    }

    public static void main(String[] args) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob11/Prob11.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            // create map
            String[] dimensions = bf.readLine().split(",");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
            map = new int[width][height];

            // fill map with zeroes
            for(int i = 0; i < width; i++) {
                for(int j = 0; j < height; j++) {
                    map[i][j] = 0;
                }
            }

            // populate map with values
            String line = null;
            while((line = bf.readLine()) != null) {

                doTask(line);

            }

            // calculate largest plot of land
            // go through every possible size

            int maxStartX = 0, maxStartY = 0, maxWidth = 0, maxHeight = 0, highestValue = 0;
            for(int w = 1; w <= width; w++) {
                for(int h = 1; h <= height; h++) {

                    // go through every possible plot of land
                    for(int x = 0; x <= width-w; x++) {
                        for(int y = 0; y <= height-h; y++) {

                            // get value of plot
                            int total = 0;
                            for(int i = x; i < x+w; i++) {
                                for(int j = y; j < y+h; j++) {

                                    total += map[i][j];

                                }
                            }
                            if((total == highestValue && w * h > maxWidth * maxHeight) || total > highestValue) {
                                highestValue = total;
                                maxStartX = x;
                                maxStartY = y;
                                maxWidth = w;
                                maxHeight = h;
                            }


                        }
                    }

                }
            }

            System.out.printf("%d,%d%n%d,%d%n$%dk%n", maxStartX+1, maxStartY+1, maxStartX+maxWidth, maxStartY+maxHeight, highestValue);

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
