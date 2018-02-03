package probs.prob14;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Prob14 {

    static String start;
    static Map<String, Integer> costs = new HashMap<>();
    static Map<String, List<List<Object>>> routes = new HashMap<>();
    static Map<String, String> cheapestSource = new HashMap<>();
    static List<String> costsKnown = new ArrayList<>();

    public static void doTask(String input) {

        String[] path = input.split(";");

        List<List<Object>> route = routes.getOrDefault(path[0], new ArrayList<>());
        List<Object> thisRoute = new ArrayList<>();
        thisRoute.add(path[1]);
        thisRoute.add(Integer.parseInt(path[2]));
        route.add(thisRoute);
        routes.put(path[0], route);

    }

    public static void main(String[] args) {

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("Java/src/probs/prob14/Prob14.in.txt").toAbsolutePath();
        try(BufferedReader bf = Files.newBufferedReader(path, charset)) {

            String[] startFinishInfo = bf.readLine().split(";");
            start = startFinishInfo[0];

            costs.put(startFinishInfo[1], 0);
            costsKnown.add(startFinishInfo[1]);

            String line = null;
            while((line = bf.readLine()) != null) {

                doTask(line);

            }

            AtomicBoolean modified = new AtomicBoolean();
            do {
                modified.set(false);

                routes.forEach((k, v) -> {
                    int currentValue = costs.getOrDefault(k, 1000000000);

                    for(List<Object> list : v) {
                        String destination = (String) list.get(0);
                        if(costs.containsKey(destination)) {
                            int newCost = (Integer) list.get(1) + costs.get(destination);
                            if(newCost < currentValue) {
                                currentValue = newCost;
                                costs.put(k, newCost);
                                cheapestSource.put(k, destination);
                                modified.set(true);
                            }
                        }
                    }
                });

            } while (modified.get());

            String currentCity = start;
            List<String> finalPath = new ArrayList<>();
            finalPath.add(start);
            while(!currentCity.equals(startFinishInfo[1])) {
                finalPath.add(cheapestSource.get(currentCity));
                currentCity = cheapestSource.get(currentCity);
            }

            System.out.printf("%s=%d%n", String.join("->", finalPath), costs.get(start));

        } catch(IOException e) {
            System.err.println(e);
        }

    }

}
