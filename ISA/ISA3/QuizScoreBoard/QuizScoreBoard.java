import java.io.*;
import java.util.*;

class NegativeScoreException extends Exception {
    NegativeScoreException(String msg) {
        super(msg);
    }
}

interface Scorable {
    int getScore();
}

class Player implements Scorable, Comparable<Player> {
    String name;
    int score;

    Player(String name, int score) throws NegativeScoreException {
        if (score < 0) {
            throw new NegativeScoreException("Score cannot be negative");
        }
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    // Sort by score descending
    public int compareTo(Player p) {
        return p.score - this.score;
    }
}

public class QuizScoreBoard {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        try {
            players.add(new Player("Alice", 80));
            players.add(new Player("Bob", 95));
            players.add(new Player("Charlie", 70));

            Collections.sort(players); // highest score first

            System.out.println("Leaderboard:");
            FileWriter fw = new FileWriter("scores.txt");
            for (Player p : players) {
                String line = p.name + " - " + p.getScore();
                System.out.println(line);
                fw.write(line + "\n");
            }
            fw.close();
            System.out.println("Saved to scores.txt");

            players.add(new Player("Dave", -10)); // invalid
        } catch (NegativeScoreException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
