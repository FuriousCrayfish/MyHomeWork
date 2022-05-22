import java.util.Random;
import java.util.Scanner;


public class HomeWork3 {

    /*Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
    попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
    указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */

    public static void main(String[] args) {

        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,};

        Scanner scanner = new Scanner(System.in);

        Random rand = new Random();

        int result = (rand.nextInt(array.length));

        int count = 1;

        a:
        while (true) {

            if (count > 3) {
                System.out.println("Вы проиграли");

                while (true) {

                    System.out.println("Хотите ли вы попробовать еще?\n1 - да, 0 - выход");

                    int ending = scanner.nextInt();
                    scanner.nextLine();

                    if (ending == 0) {
                        System.out.println("До встречи!");
                        break a;

                    } else if (ending == 1) {
                        System.out.println("Попробуйте снова");
                        result = (rand.nextInt(array.length));
                        count = 1;
                        continue a;
                    } else {

                        System.out.println("Вы ввели некорректное значение, попробуйте снова");

                    }
                }

            }

            System.out.print("Введите число: ");

            int number = scanner.nextInt();
            scanner.nextLine();

            if (number == result) {
                System.out.println("Вы угадали число! Поздравляю!");

                while (true) {

                    System.out.println("Хотите ли вы попробовать еще?\n1 - да, 0 - выход");

                    int ending = scanner.nextInt();
                    scanner.nextLine();

                    if (ending == 0) {
                        System.out.println("До встречи!");
                        break a;

                    } else if (ending == 1) {
                        System.out.println("Попробуйте снова");
                        result = (rand.nextInt(array.length));
                        count = 1;
                        continue a;
                    } else {

                        System.out.println("Вы ввели некорректное значение, попробуйте снова");

                    }
                }

            } else if (number > result) {
                count++;

                System.out.println("Введенное число больше загаданного");

            } else {

                count++;

                System.out.println("Введенное число меньше загаданного");

            }

        }

    }

}



