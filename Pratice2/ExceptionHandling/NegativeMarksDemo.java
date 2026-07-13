import java.util.Scanner;
class NegativeMarksException extends Exception {

    public NegativeMarksException(String message) {
        super(message);
    }
    

}

public class NegativeMarksDemo {

    public static void isNegative(int marks)  throws NegativeMarksException{
               if(marks<0){
                throw new NegativeMarksException("Num is Negative");
               }
    }

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Marks:");
    int marks = sc.nextInt();
    try{
       isNegative(marks);
    }catch(NegativeMarksException e){
        System.out.println(e);
    }

}
}
