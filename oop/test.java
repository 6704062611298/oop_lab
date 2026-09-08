// A small object-oriented programming demo.
// Demonstrates encapsulation, inheritance, and polymorphism.
// Run with:  javac test.java && java test

// Base class — shows encapsulation via private fields + accessors.
abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    // Every animal makes a sound — subclasses must implement this.
    public abstract String sound();

    // Polymorphism: same call, different behavior per subclass.
    public void introduce() {
        System.out.printf("I'm %s, %d year(s) old, and I say: %s%n",
                name, age, sound());
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public String sound() { return "Woof!"; }

    @Override
    public void introduce() {
        super.introduce();
        System.out.printf("  (a %s dog)%n", breed);
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String sound() { return "Meow~"; }
}

public class test {
    public static void main(String[] args) {
        Animal[] pets = {
            new Dog("Rex", 4, "Labrador"),
            new Cat("Mittens", 2),
            new Dog("Bella", 1, "Beagle")
        };

        for (Animal pet : pets) {
            pet.introduce();
        }
    }
}
