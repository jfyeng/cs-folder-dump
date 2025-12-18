
class Person {
    // Fields - variables that belong to the class or object
    String name;
    int age;

    // Methods - functions inside class

    // Constructor
    public Person(String name, int a) {
        this.name = name;
        age = a;
    }

    public void hi() {
        if (age < 12) {
            System.out.println("Yo.");
        } else if (age < 18) {
            System.out.println("'Sup?");
        } else {
            System.out.println("Greetings.");
        }
    }

    // When we make a method that we get from the super-class, this is called "overriding".
    @Override
    public String toString() {
        return name + " " + age;
    }
}