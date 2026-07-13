import java.util.ArrayList;
import java.util.Scanner;

public record ArrayListDemo() {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<>();

    System.out.print("Enter the element to ne added:");
    String a = sc.nextLine();
    list.add(a);
    System.out.print("Enter the element to ne added:");
     a = sc.nextLine();
    list.add(a);
    System.out.print("Enter the element to be removed:");
     a = sc.nextLine();
    list.remove(a);

    System.out.println("Display Data:"+list);
}
}
