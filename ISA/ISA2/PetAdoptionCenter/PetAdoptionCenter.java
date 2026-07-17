abstract class Pet {
    String name;
    String type;

    Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract void describe();
}

class Dog extends Pet {
    Dog(String name) {
        super(name, "Dog");
    }

    void describe() {
        System.out.println(name + " is a friendly dog");
    }
}

class Cat extends Pet {
    Cat(String name) {
        super(name, "Cat");
    }

    void describe() {
        System.out.println(name + " is a cute cat");
    }
}

public class PetAdoptionCenter {
    // return all pets of a given type
    static Pet[] petsOfType(Pet[] arr, String type) {
        int count = 0;
        for (Pet p : arr) {
            if (p.type.equals(type)) count++;
        }
        Pet[] result = new Pet[count];
        int i = 0;
        for (Pet p : arr) {
            if (p.type.equals(type)) {
                result[i++] = p;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Pet[] pets = {
            new Dog("Buddy"),
            new Cat("Lucy"),
            new Dog("Maxy"),
            new Cat("Milly")
        };

        System.out.println("--- Available Pets ---");
        for (Pet p : pets) {
            p.describe();
            // if name ends with "y", mark Popular
            if (p.name.endsWith("y")) {
                System.out.println("  ** Popular **");
            }
        }

        System.out.println("\n--- Dogs only ---");
        Pet[] dogs = petsOfType(pets, "Dog");
        for (Pet d : dogs) {
            d.describe();
        }
    }
}
