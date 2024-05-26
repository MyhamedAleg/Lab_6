import java.util.Scanner;

public class Person {
    private final String fullName;
    private final int age;

    // Конструктор без параметрів
    public Person() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть повне ім'я:");
        fullName = scanner.nextLine();
        System.out.println("Введіть вік:");
        age = scanner.nextInt();
    }

    // Конструктор з параметрами fullName і age
    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    // Метод для переміщення
    public void move() {
        System.out.println(fullName + " переміщується");
    }

    // Метод для розмови
    public void talk() {
        System.out.println(fullName + " говорить");
    }

    public static void main(String[] args) {
        // Створення об'єктів класу Person з використанням різних конструкторів
        Person person1 = new Person(); // Викликається конструктор без параметрів
        Person person2 = new Person("John Doe", 30); // Викликається конструктор з параметрами

        // Виклик методів для об'єктів класу Person
        person1.move();
        person1.talk();

        person2.move();
        person2.talk();
    }
}
