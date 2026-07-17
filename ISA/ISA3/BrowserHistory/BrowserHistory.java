import java.io.*;
import java.util.*;

class NoHistoryException extends Exception {
    NoHistoryException(String msg) {
        super(msg);
    }
}

interface Navigable {
    void visit(String url);
    void goBack() throws NoHistoryException;
}

class Browser implements Navigable {
    Stack<String> history = new Stack<>();

    public void visit(String url) {
        history.push(url);
        System.out.println("Visited: " + url);
    }

    public void goBack() throws NoHistoryException {
        if (history.isEmpty()) {
            throw new NoHistoryException("No history to go back");
        }
        String url = history.pop();
        System.out.println("Went back from: " + url);
    }

    void saveHistory() throws IOException {
        FileWriter fw = new FileWriter("history.txt");
        for (String url : history) {
            fw.write(url + "\n");
        }
        fw.close();
        System.out.println("Saved remaining history to history.txt");
    }
}

public class BrowserHistory {
    public static void main(String[] args) {
        Browser b = new Browser();
        try {
            b.visit("google.com");
            b.visit("youtube.com");
            b.visit("github.com");
            b.goBack();
            b.saveHistory();

            b.goBack();
            b.goBack();
            b.goBack(); // empty stack
        } catch (NoHistoryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
