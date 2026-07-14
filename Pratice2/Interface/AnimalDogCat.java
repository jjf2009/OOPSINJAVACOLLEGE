package Pratice2.Interface;

interface Animal{
    void sound();
}

class Dog implements Animal{ 
    public void sound(){
        System.out.println("Dog is Braking");
    }
    
}
class Cat implements Animal{ 
    public void sound(){
        System.out.println("Cat is Meoving");
    }
    
}

public class AnimalDogCat {
    public static void main(String[ ] args){
           Animal d = new Dog();
           d.sound();
           Animal c = new Cat();
           c.sound();
    }
}
