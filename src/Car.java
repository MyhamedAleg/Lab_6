import java.util.Scanner;

// Абстрактний клас Car
abstract class Car {
    protected String model;
    protected String color;
    protected int maxSpeed;

    // Конструктор
    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // Метод газування
    public void gas() {
        System.out.println("Машина " + model + " газує!");
    }

    // Абстрактний метод гальмування
    public abstract void brake();
}

// Похідний клас Sedan
class Sedan extends Car {
    // Конструктор
    public Sedan(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    // Реалізація методу гальмування
    @Override
    public void brake() {
        System.out.println("Седан " + model + " гальмує");
    }
}

// Похідний клас Truck
class Truck extends Car {
    // Конструктор
    public Truck(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    // Реалізація методу гальмування
    @Override
    public void brake() {
        System.out.println("Грузовик " + model + " гальмує");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = null; // Початкове значення об'єкта машини

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити седан");
            System.out.println("2. Створити грузовик");
            System.out.println("3. Газувати");
            System.out.println("4. Гальмувати");
            System.out.println("5. Вийти");

            System.out.println("Оберіть опцію:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Введіть модель седана:");
                    String sedanModel = scanner.next();
                    System.out.println("Введіть колір седана:");
                    String sedanColor = scanner.next();
                    System.out.println("Введіть максимальну швидкість седана:");
                    int sedanMaxSpeed = scanner.nextInt();
                    car = new Sedan(sedanModel, sedanColor, sedanMaxSpeed);
                    break;
                case 2:
                    System.out.println("Введіть модель грузовика:");
                    String truckModel = scanner.next();
                    System.out.println("Введіть колір грузовика:");
                    String truckColor = scanner.next();
                    System.out.println("Введіть максимальну швидкість грузовика:");
                    int truckMaxSpeed = scanner.nextInt();
                    car = new Truck(truckModel, truckColor, truckMaxSpeed);
                    break;
                case 3:
                    if (car != null) {
                        car.gas();
                    } else {
                        System.out.println("Спочатку створіть машину.");
                    }
                    break;
                case 4:
                    if (car != null) {
                        car.brake();
                    } else {
                        System.out.println("Спочатку створіть машину.");
                    }
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Програма завершила роботу.");
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
}
