package probs.prob12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob12 {

    static HashMap<String, Boolean> map = new HashMap<>();
    static int width;
    static int height;

    public static void doTask(String input, int lineNumber) {

        String[] blocks = input.split("");
        for(int i = 0; i < blocks.length; i++) {
            String coor = i + "," + lineNumber;
            map.put(coor, blocks[i].equals("O"));
        }
        width = blocks.length;
        height = lineNumber+1;

    }

    public static void main(String[] args) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob12/Prob12.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String line = null;
            int lineNumber = 0;
            while((line = bf.readLine()) != null) {

                doTask(line, lineNumber++);

            }

        } catch(IOException e) {
            System.err.println(e);
        }

        // traverse the map!
        List<String> safePath = new ArrayList<>();
        List<String> newPath = new ArrayList<>();

        // algorithm: trim all ends
        boolean endFound;
        do {
            endFound = false;
            for (int i = 1; i < width-1; i++) {
                for (int j = 0; j < height; j++) {

                    String c = i + "," + j;
                    String l = (i-1) + "," + j;
                    String t = i + "," + (j-1);
                    String r = (i+1) + "," + j;
                    String b = i + "," + (j+1);

                    // for top and bottom edges
                    if(j == 0 || j == height-1) {
                        if(j == 0 && map.get(c)) {
                            int sum =
                                (map.get(l) ? 1 : 0) +
                                (map.get(r) ? 1 : 0) +
                                (map.get(b) ? 1 : 0);
                            if(sum < 2) {
                                map.put(c, false);
                                endFound = true;
                            }
                        } else if(j == height-1 && map.get(c)) {
                            int sum =
                                    (map.get(l) ? 1 : 0) +
                                    (map.get(r) ? 1 : 0) +
                                    (map.get(t) ? 1 : 0);
                            if(sum < 2) {
                                map.put(c, false);
                                endFound = true;
                            }
                        } else if(j == height-1 && map.get(c)) {

                        }
                    } else {
                        if(map.get(c)) {
                            int sum =
                                (map.get(t) ? 1 : 0) +
                                (map.get(l) ? 1 : 0) +
                                (map.get(r) ? 1 : 0) +
                                (map.get(b) ? 1 : 0);
                            if(sum < 2) {
                                map.put(c, false);
                                endFound = true;
                            }
                        }
                    }

                }
            }
        } while(endFound);

        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {
                System.out.print(map.get(i + "," + j) ? "O" : "X");
            }
            System.out.println();
        }

    }

}
