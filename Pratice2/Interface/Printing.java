interface Printable2 {
    void print();
}

class Student2 implements Printable2 {
    String Name;
    double marks;

    Student2(String name , double marks){
        Name = name;
        this.marks = marks;
    }

    public void print(){
        System.out.println("Name of the Student"+Name+"Marks of the Students"+marks);
    }
}

public class Printing {
    public static void main(String args[]){
        Printable2 s = new Student2("Jared", 0);
         s.print();
    }

   
}
