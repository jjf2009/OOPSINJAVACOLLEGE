public class NullPointerDemo {
    public static void main(String[] args) {
        String text = null;

        try {
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Error: String reference is null.");
        }
    }
}