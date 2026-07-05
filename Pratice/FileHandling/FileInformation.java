import java.io.File;

public class FileInformation {
    public static void main(String[] args) {
        File file = new File("sample.txt");

        if (file.exists()) {
            System.out.println("File Name : " + file.getName());
            System.out.println("File Size : " + file.length() + " bytes");
            System.out.println("Absolute Path: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
}