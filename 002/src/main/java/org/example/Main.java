package org.example;

/*
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}*/

import java.util.Random;
import java.util.Scanner;

public class Main { //GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int repeat;
        do {
            int target = random.nextInt(11); // 0..10 включительно
            int attemptsLeft = 3;
            boolean guessed = false;

            System.out.println("Я загадал число от 0 до 10. У вас 3 попытки.");

            while (attemptsLeft > 0 && !guessed) {
                System.out.print("Ваш вариант: ");

                // Защита от ввода не-числа
                if (!scanner.hasNextInt()) {
                    System.out.println("Введите целое число!");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess == target) {
                    System.out.println("Поздравляю! Вы угадали число " + target + "!");
                    guessed = true;
                } else {
                    attemptsLeft--;
                    if (guess < target) {
                        System.out.println("Загаданное число БОЛЬШЕ.");
                    } else {
                        System.out.println("Загаданное число МЕНЬШЕ.");
                    }

                    if (attemptsLeft > 0) {
                        System.out.println("Осталось попыток: " + attemptsLeft);
                    }
                }
            }

            if (!guessed) {
                System.out.println("Вы проиграли. Было загадано число: " + target);
            }

            System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
            System.out.println("Ваш вариант:");
            System.out.println("=========================================");

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Введите 1 или 0:");

            }
            repeat = scanner.nextInt();

        } while (repeat == 1);

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}