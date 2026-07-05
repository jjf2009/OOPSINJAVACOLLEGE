interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows: Meow Meow!");
    }
}

public class AnimalSound {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.sound();
        cat.sound();
    }
}