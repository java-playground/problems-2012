/**
 *
 * This solution is terribly complicated
 * Can just compare solutions by comparing lines, not by creating indeces of correct answers in lists and comparing them
 *
 */

package probs.prob7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prob7 {

    public static int points;
    public static List<List<Integer>> answers;
    public static int studentId;
    public static int studentTotal;
    public static int questionsFinished;

    public static void doTask(String input) {

        Pattern newStudent = Pattern.compile("STUDENT (\\d+)");
        Matcher m = newStudent.matcher(input);
        if(m.find()) {
            studentId = Integer.parseInt(m.group(1));
            questionsFinished = 0;
            studentTotal = 0;
            return;
        }

        String[] options = input.split(" ");
        List<Integer> questionAnswers = new ArrayList<>();
        for(int i = 0; i < options.length; i++) {
            if(options[i].equals("=")) {
                questionAnswers.add(i);
            }
        }

        if(questionAnswers.equals(answers.get(questionsFinished++))) {
            studentTotal++;
        }

        if(questionsFinished == 100 / points) {
            System.out.printf("STUDENT %d: %d%n", studentId, studentTotal*points);
            return;
        }

    }

    public Prob7() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob7/Prob07.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            points = Integer.parseInt(bf.readLine());
            answers = new ArrayList<List<Integer>>();
            for(int i = 0; i < 100 / points; i++) {
                String[] questionOptions = bf.readLine().split(" ");
                List<Integer> questionAnswers = new ArrayList<>();
                for(int j = 0; j < questionOptions.length; j++) {
                   if(questionOptions[j].equals("=")) {
                       questionAnswers.add(j);
                   }
                }
                answers.add(questionAnswers);
            }

            String line = null;
            while((line = bf.readLine()) != null) {

                doTask(line);

            }

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}

