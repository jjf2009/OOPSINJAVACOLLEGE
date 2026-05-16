import java.io.*;
import java.util.*;

class Player {
    private String name;
    private int runs;

    public Player() {}
    public Player(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    public int getRuns() { return runs; }

    @Override
    public String toString() { return name + " scored " + runs + " runs."; }
}

public class CricketStats {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("players.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                players.add(new Player(data[0], Integer.parseInt(data[1])));
            }
            
            Player top = players.get(0);
            for (Player p : players) if (p.getRuns() > top.getRuns()) top = p;

            try (PrintWriter out = new PrintWriter("top_scorer.txt")) {
                out.println("Highest Scorer: " + top.toString());
            }
            System.out.println("Top scorer written to top_scorer.txt");
        } catch (IOException e) { System.err.println("Error: " + e.getMessage()); }
    }
}