package org.example.homework;

import java.util.HashMap;
import java.util.Random;


/*
    Реализовать Java приложение для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия)
    и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
    Студенту необходимо:
    Создать свой Java Maven/Gradle проект;
    Реализовать прикладную задачу - приложение для демонстрации парадокса Монти Холла;
    Можно добавить любые библиотеки которые считают необходимыми
    Результаты должны быть сохранены в HashMap (шаг цикла -> результат)
    Необходимо вывести статистику по результату - количество позитивных и
    негативных результатов, процент от общего количества шагов цикла.
 */

public class Main {
    public static void main(String[] args) {

        // Создаем HashMap для хранения результатов игры:
        HashMap<Integer, String> results = new HashMap<>();

        // Количество испытаний:
        int trials = 1000;
        // Количество выигрышей при смене двери:
        int switchWins = 0;
        // Количество выигрышей при сохранении двери:
        int stayWins = 0;
        // Генератор случайных чисел:
        Random random = new Random();

        // Цикл игры:
        for (int i = 0; i < trials; i++) {
            // Создаем HashMap для хранения дверей с призами и козами
            //AtomicReference<HashMap<Integer, String>> doors = new AtomicReference<>(new HashMap<>());
            HashMap<Integer, String> doors = new HashMap<>();
            doors.put(1, "Автомобиль");
            doors.put(2, "Коза");
            doors.put(3, "Коза");

            // Случайный выбор двери за которой приз:
            int prize = random.nextInt(3) + 1;
            // Перемещаем приз за выбранную дверь:
            doors.put(prize, "Приз");
            doors.put(1, "Коза");
            // Случайный выбор двери игрока:
            int choice = random.nextInt(3) + 1;
            // Случайный выбор двери ведущим:
            int doorOpened = random.nextInt(3) + 1;
            // Ограничение на выбор двери ведущим(не приз и не выбор игрока):
            while (doorOpened == prize || doorOpened == choice) {
                doorOpened = random.nextInt(3) + 1;
            }
            // Случайный выбор игрока, после открытия двери ведущим:
            boolean switchChoice = random.nextBoolean();
            // Если новый выбор - дверь не была открыта и не выбрана изначально:
            if (switchChoice) {
                int newChoice = 6 - choice - doorOpened;
                // Если новый выбор - приз:
                if (newChoice == prize) {
                    switchWins++;
                    results.put(i, "Приз при смене двери");
                }
                // Если новый выбор - коза:
                else {
                    results.put(i, "Коза при смене двери");
                }
            }
            // Если игрок остался при своем выборе:
            else {
                // Если выбор совпал с призом:
                if (choice == prize) {
                    stayWins++;
                    results.put(i, "Приз при сохранении двери");
                }
                // Если выбор совпал с козой:
                else {
                    results.put(i, "Коза при сохранении двери");
                }
            }
        }

        // Вывод результатов:
        for (int i = 0; i < trials; i++) {
            System.out.println("Игра " + (i + 1) + ": " + results.get(i));
        }

        // Вывод статистики:
        System.out.println("Количество открытий дверей: " + trials);
        System.out.println("Количество выигрышей при смене: " + switchWins + "(" + 100.0 * switchWins / trials + "%)");
        System.out.println("Количество выигрышей при сохранении: " + stayWins + "(" + 100.0 * stayWins / trials + "%)");
        System.out.println("Количество негативных результатов: " + (trials - switchWins - stayWins) + "(" + 100.0 * (trials - switchWins - stayWins) / trials + "%)");

    }
}
