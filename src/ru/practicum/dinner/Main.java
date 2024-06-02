package ru.practicum.dinner;

import java.util.*;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static HashMap<String, ArrayList<String>> menu = new HashMap<>();


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Работа программы оконченна!");
                    return;
                default:
                    System.out.println("Такой комманды нет.");
                    System.out.println("-".repeat(30));
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        if (dc.addNewDish(menu, dishType, dishName)) {
            System.out.println("-".repeat(30));
        } else {
            System.out.println("Такое блюдо уже существует в данной категории.");
            System.out.println("-".repeat(30));
        }
        // добавьте новое блюдо

    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();
        if (menu.isEmpty()) {
            System.out.println("Список блюд пуст.");
            System.out.println("-".repeat(30));
            return;
        }
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        while (numberOfCombos < 1) {
            System.out.println("Количество наборов не может быть меньше 1, введите другое число.");
            numberOfCombos = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.println("Введите типы блюда, разделяя символом переноса строки (enter)." +
                " Для завершения ввода введите пустую строку");
        String nextItem = ".";

        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            if (!menu.containsKey(nextItem) && !nextItem.isEmpty()) {
                System.out.println(nextItem + " - такого типа блюд нет в списке. Введите другой тип.");
            } else if (!nextItem.isEmpty()) {
                types.add(nextItem);
            }
        }

        ArrayList<ArrayList<String>> combo = dc.generateCombo(menu, types, numberOfCombos);
        for (int i = 0; i < combo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo.get(i));
            System.out.println("-".repeat(30));
        }
    }
}
