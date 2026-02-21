import java.util.Scanner;

class Player {
    private String name;
    private int runs;

    public Player(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    public int getRuns() {
        return runs;
    }

    public String getName() {
        return name;
    }
}

public class CricketStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter runs scored: ");
            int runs = sc.nextInt();
            sc.nextLine();

            players[i] = new Player(name, runs);
        }

        Player highest = players[0];

        for (int i = 1; i < n; i++) {
            if (players[i].getRuns() > highest.getRuns()) {
                highest = players[i];
            }
        }

        System.out.println("Highest Scorer: " + highest.getName() +
                " with " + highest.getRuns() + " runs");
    }
}