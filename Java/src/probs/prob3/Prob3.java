package probs.prob3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Prob3 {

    public Prob3() {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("./Java/src/probs/prob3/Prob03.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {
            String line = null;
            while((line = bf.readLine()) != null) {

                System.out.println(line);

                try {
                    // make into int array
                    int[] nums = Arrays.stream(line.split(" "))
                            .mapToInt(n -> Integer.parseInt(n))
                            .toArray();
                    boolean descending = true;
                    boolean ascending = true;
                    for(int i = 1; i < nums.length; i++) {
                        if(nums[i] <= nums[i-1]) ascending = false;
                        if(nums[i] >= nums[i-1]) descending = false;
                    }
                    if(ascending) {
                        System.out.println("The numbers are in ascending order");
                    } else if(descending) {
                        System.out.println("The numbers are in descending order");
                    } else {
                        System.out.println("The numbers are in random order");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("The input was invalid");
                }

            }
        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
