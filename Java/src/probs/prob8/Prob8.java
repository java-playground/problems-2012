/*
* This one was hard! Had to look at the solution (oops)
* */

package probs.prob8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Prob8 {

    public static void doTask(String input) {

        boolean square;
        switch(input.length() % 4) {
            case 0:
                square = true;
                break;
            case 1:
                square = false;
                input += " ";
                break;
            case 2:
                square = false;
                break;
            default:
                square = true;
                input += " ";
        }
        input = input.replaceAll(" ", ".");

        String top, left, right, bottom;
        int l = input.length();
        int w, h;
        if(square) {
            w = l/4+1;
            h = l/4-1;
        } else {
            w = (l+2)/4+1;
            h = (l-2)/4-1;
        }
        top = input.substring(0, w);
        bottom = new StringBuilder(input.substring(l/2, l/2+w)).reverse().toString();
        right = input.substring(w, w+h);
        left = new StringBuilder(input.substring(l-h)).reverse().toString();

        // print top
        System.out.println(top);

        // print sides
        for(int i = 0; i < left.length(); i++) {
            System.out.print(left.charAt(i));
            for(int j = 0; j < top.length()-2; j++) {
                System.out.print(" ");
            }
            System.out.println(right.charAt(i));
        }

        // print bottom
        System.out.println(bottom);


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
