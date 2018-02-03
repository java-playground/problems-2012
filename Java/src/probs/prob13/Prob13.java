package probs.prob13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob13 {

    static List<List<Object>> rules = new ArrayList<>();

    static boolean readingKey = true;

    static String studentId = "-1";
    static int studentScore = 0;

    public static void doTask(String input) {

        if(readingKey) {
            if (input.equals("999")) {
                readingKey = false;
                return;
            }

            // the rule will be: questionNumber, points, type, pattern
            Pattern parts = Pattern.compile("^(\\d+) (\\-?\\d+) ([A-Z]{2}) (.+)$");
            Matcher partsMatcher = parts.matcher(input);
            partsMatcher.find();

            int questionNumber = Integer.parseInt(partsMatcher.group(1));

            int points = Integer.parseInt(partsMatcher.group(2));
            String type = partsMatcher.group(3);
            String[] patterns = partsMatcher.group(4).split(",");
            for (int i = 0; i < patterns.length; i++) {
                patterns[i] = patterns[i].substring(1, patterns[i].length() - 1);
            }

            Pattern rulePattern = (type.equals("EQ")) ? Pattern.compile("^(" + String.join("|", patterns) + ")$") : Pattern.compile(String.join("|", patterns));

            List<Object> rule = new ArrayList<>();
            rule.add(questionNumber);
            rule.add((Integer) points);
            rule.add(type);
            rule.add(rulePattern);

            rules.add(rule);
        } else {
            // reading student responses
            Pattern parts = Pattern.compile("^(\\d{3}) (\\d+) \"(.+)\"$");
            Matcher partsMatcher = parts.matcher(input);
            partsMatcher.find();

            // if student change
            if(!studentId.equals(partsMatcher.group(1))) {
                if(!studentId.equals("-1")) {
                    System.out.printf("STUDENT %s TOTAL %d%n", studentId, studentScore);
                }
                studentId = partsMatcher.group(1);
                studentScore = 0;
            }

            int questionId = Integer.parseInt(partsMatcher.group(2));
            String response = partsMatcher.group(3);
            int questionScore = 0;

            // get matching rule(s), check it against answer
            for(int i = 0; i < rules.size(); i++) {
                List<Object> rule = rules.get(i);
                if((Integer) rule.get(0) == questionId) {

                    // check rule
                    boolean answerValid = true;
                    Matcher ruleMatcher = ((Pattern) rule.get(3)).matcher(response);
                    if(rule.get(2).equals("EQ") || rule.get(2).equals("IN")) {
                        if(!ruleMatcher.find()) {
                            answerValid = false;
                        }
                    } else {
                        if(ruleMatcher.find()) {
                            answerValid = false;
                        }
                    }
                    if(answerValid) {
                        int score = (Integer) rule.get(1);
                        questionScore += score;
                    }

                }
            }
            System.out.printf("STUDENT %s %d %d%n", studentId, questionId, Math.max(0, questionScore));
            studentScore += Math.max(0, questionScore);

        }

    }

    public static void main(String[] args) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob13/Prob13.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String line = null;
            while((line = bf.readLine()) != null) {

                doTask(line);

            }

            // necessary for printing out last person stats
            System.out.printf("STUDENT %s TOTAL %d%n", studentId, studentScore);

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
