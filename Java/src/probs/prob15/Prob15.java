/**
 * OI THIS WAS TEDIOUS
 */

package probs.prob15;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob15 {

    static List<String> regexes = new ArrayList<>();

    public static boolean doTask(String input) {

        for(String regex : regexes) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            if(m.find()) return true;
        }

        return false;

    }

    public static void main(String[] args) {

        // input regexes
        Collections.addAll(regexes,
                "^CW3101A.*\\-.*(P|S)$",
                "^CW426.*\\-.*$",
                "^CW427\\-.*C.*$",
                "^CW500A4\\-(3|4|5|6|7|8)$",
                "^CW507B1032R(8|30|32|([12][02468]))$",
                "^CW3085\\-((0([0-4][0-9]|50))|1(0[2-9]|7[0-8]|[1-6][0-9])|2(0[1-9]|8[0-4]|[1-7][0-9]))$",
                "^CWCG20Z\\-(M|N|P|Q|R|S)([2-9][0-9][0-9]|1[1-9][0-9]|10[1-9])B$",
                "^CWDPX2\\-.*(P|S).*(P|S)33\\-00.*$",
                "^CWT02(E|P)18\\-(11|32)(P|S).*$",
                "^CW12326(E|G|J|K|L|M|N|P|R|T)(1\\d{4}|20000|0\\d{3}|00[4-9]\\d{2}|003[8-9][0-9]|0037[5-9])(A|S)$",
                "^CW15232C(02|04|06|08|[3-6])(\\-|H)([0-9]|1[0-6]|[2-4][92468]|18)$",
                "^CW15263\\-(02|04|06|08|3|4|5|6)(\\-|H)([0-9]|1[0-6]|[2-4][92468]|18|59)$",
                "^CW20001(C|P)(H|X|Y)(2|3|4|5|6|8|9|10|12|14|16|17)\\-(0[1-9]\\d{2}|[1-6]\\d{3}|7[0-1]\\d{2}|7200)$",
                "^CW102\\-2\\-([6-9]|[1-4][02468]|50)\\-(6|7|8|9|([1-4][02468])|50)$",
                "^CW8602\\-.*B.*PNSPM26$");

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob15/Prob15.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String line = null;
            while((line = bf.readLine()) != null) {

                if(doTask(line)) {
                    System.out.println(line);
                }

            }

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
