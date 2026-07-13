public class NullPointerException {
public static void main(String[] args){
    String text = null;
    try {
System.out.println("Lenght of String:"+text.length());
    }catch(NullPointerException e ){
       System.out.println(e);
    }

}
}
