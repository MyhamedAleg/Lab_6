import java.util.Scanner;

 class PostalSorting {
    private String city;
    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private int parcelQuantity;
    private double cost;

    // Конструктор класу
    public PostalSorting() {
        // За замовчуванням всі поля будуть ініціалізовані нульовими значеннями або порожніми рядками
    }

    // Функція для введення даних
    public void inputData(Scanner scanner) {
        scanner.nextLine(); // Очищаємо буфер вводу
        System.out.println("Введіть місто:");
        city = scanner.nextLine();

        System.out.println("Введіть вулицю:");
        street = scanner.nextLine();

        System.out.println("Введіть номер будинку:");
        houseNumber = scanner.nextInt();

        System.out.println("Введіть номер квартири:");
        apartmentNumber = scanner.nextInt();

        System.out.println("Введіть кількість посилок:");
        parcelQuantity = scanner.nextInt();

        System.out.println("Введіть вартість:");
        cost = scanner.nextDouble();
    }

    // Функція для виведення даних
    public void displayData() {
        System.out.println("Місто: " + city);
        System.out.println("Вулиця: " + street);
        System.out.println("Номер будинку: " + houseNumber);
        System.out.println("Номер квартири: " + apartmentNumber);
        System.out.println("Кількість посилок: " + parcelQuantity);
        System.out.println("Вартість: " + cost);
    }

    // Функція для обчислення сумарної кількості посилок
    public static int calculateTotalParcelQuantity(PostalSorting[] postalSortings) {
        int totalQuantity = 0;
        for (PostalSorting postalSorting : postalSortings) {
            if (postalSorting != null) {
                totalQuantity += postalSorting.parcelQuantity;
            }
        }
        return totalQuantity;
    }

    // Функція для обчислення сумарної вартості
    public static double calculateTotalCost(PostalSorting[] postalSortings) {
        double totalCost = 0;
        for (PostalSorting postalSorting : postalSortings) {
            if (postalSorting != null) {
                totalCost += postalSorting.cost;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostalSorting[] postalSortings = new PostalSorting[3]; // Масив об'єктів класу PostalSorting

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Ввести або переглянути дані про будинок");
            System.out.println("2. Обчислити сумарну кількість посилок");
            System.out.println("3. Обчислити сумарну вартість");
            System.out.println("4. Вийти");

            System.out.println("Оберіть опцію:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Ввести дані про будинок");
                    System.out.println("2. Переглянути дані про будинок");
                    int inputOption = scanner.nextInt();
                    if (inputOption == 1) {
                        for (int i = 0; i < postalSortings.length; i++) {
                            if (postalSortings[i] == null) {
                                System.out.println("Дані для будинку #" + (i + 1));
                                postalSortings[i] = new PostalSorting(); // Створення нового об'єкта класу PostalSorting
                                postalSortings[i].inputData(scanner); // Виклик методу для введення даних
                                break; // Вийти з циклу після успішного введення даних
                            } else if (i == postalSortings.length - 1) {
                                System.out.println("Всі місця для введення даних зайняті.");
                            }
                        }
                    } else if (inputOption == 2) {
                        System.out.println("Введені дані про будинок:");
                        for (PostalSorting postalSorting : postalSortings) {
                            if (postalSorting != null) {
                                postalSorting.displayData();
                            }
                        }
                    } else {
                        System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    }
                    break;
                case 2:
                    int totalParcelQuantity = PostalSorting.calculateTotalParcelQuantity(postalSortings);
                    System.out.println("Сумарна кількість посилок: " + totalParcelQuantity);
                    break;
                case 3:
                    double totalCost = PostalSorting.calculateTotalCost(postalSortings);
                    System.out.println("Сумарна вартість: " + totalCost);
                    break;
                case 4:
                    scanner.close(); // Закрити Scanner
                    System.out.println("Програма завершила роботу.");
                    System.exit(0); // Вийти з програми
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
}
