import java.util.Scanner;

public class Phone {
    private final String number;
    private String callerName;

    // Конструктор з параметрами number, model і weight
    public Phone(String number, String model, double weight) {
        this.number = number;
    }

    // Конструктор з параметрами number і model
    public Phone(String number, String model) {
        this(number, model, 0.0);
    }

    // Конструктор без параметрів
    public Phone() {
        this("Unknown", "Unknown", 0.0);
    }

    // Метод для отримання номера телефону
    public String getNumber() {
        return number;
    }

    // Метод для встановлення імені абонента
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    // Метод для отримання імені абонента
    public String getCallerName() {
        return callerName;
    }

    // Метод для прийому дзвінка з ім'ям абонента
    public void receiveCall() {
        System.out.println("Дзвонить " + callerName);
    }

    // Перевантажений метод для прийому дзвінка з ім'ям абонента та номером телефону
    public void receiveCall(String callerNumber) {
        System.out.println("Дзвонить " + callerName + " (" + callerNumber + ")");
    }

    // Метод для відправлення повідомлення
    public void sendMessage(String... numbers) {
        System.out.println("Номери, яким буде надіслано повідомлення: ");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Phone[] phones = new Phone[3]; // Масив для трьох телефонів

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Ввести дані про телефон");
            System.out.println("2. Викликати методи для телефону");
            System.out.println("3. Вийти");

            System.out.println("Оберіть опцію:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    for (int i = 0; i < phones.length; i++) {
                        System.out.println("Телефон #" + (i + 1));
                        System.out.println("Введіть номер телефону:");
                        String number = scanner.next();
                        System.out.println("Введіть модель телефону:");
                        String model = scanner.next();
                        System.out.println("Введіть вагу телефону:");
                        double weight = scanner.nextDouble();
                        System.out.println("Введіть ім'я абонента:");
                        String callerName = scanner.next();

                        phones[i] = new Phone(number, model, weight);
                        phones[i].setCallerName(callerName);
                    }
                    break;
                case 2:
                    if (phones[0] != null) {
                        System.out.println("Оберіть телефон (від 1 до " + phones.length + "): ");
                        int selectedPhone = scanner.nextInt();
                        if (selectedPhone > 0 && selectedPhone <= phones.length) {
                            Phone phone = phones[selectedPhone - 1];
                            phone.receiveCall();
                        } else {
                            System.out.println("Неправильний вибір телефону.");
                        }
                    } else {
                        System.out.println("Спочатку введіть дані про телефони.");
                    }
                    break;
                case 3:
                    scanner.close();
                    System.out.println("Програма завершила роботу.");
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
}
