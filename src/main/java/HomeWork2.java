public class HomeWork2 {

    /*Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
     0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */


    public static void arrayChange() {
// length переменная указывающая длинну созданного массива

        System.out.println();

        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;

            } else {
                array[i] = 1;
            }
            System.out.print(array[i]);
        }
        System.out.println(" измененный массив");

    }



    /*Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    значениями 0 3 6 9 12 15 18 21;*/


    public static void arrayCompletion() {

        System.out.println();

        int[] array = new int[8];

        for (int i = 0; i < array.length; i++) {

            array[i] = i * 3;

            System.out.print(array[i] + " ");
        }


    }

    /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    умножить на 2;*/

    public static void arrayMultiplication() {

        System.out.println();

        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {

            if (array[i] < 6) {

                array[i] = array[i] * 2;
            }
            System.out.print(array[i] + " ");
        }

    }

    /*Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/


    public static void arrayDiagonal() {

        System.out.println();

        int[][] array = new int[3][3];

        for (int i = 0; i < array.length; i++) {

            for (int j = 0, x = array[i].length; j < array[i].length; j++, x--) {
                if (i == j || i == x - 1) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");


            }
            System.out.println();
        }

    }

    /*Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
помощи интернета);*/

    public static void arrayMaxMin() {

        System.out.println();

        int[] array = new int[]{0, 10, 5, 8, 12};

        int min = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {

                min = array[i];
            }

            if (array[i] > max) {

                max = array[i];

            }

        }

        System.out.println("Минимальное значение массив " + min + "\n" + "Максимальное число массива " + max);

    }

    /*Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
    2, 1]) → true, граница показана символами ||, эти символы в массив не входят*/

    public static boolean checkBalanse(int[] array) {

        System.out.println();

        /*1, 1, 1, 2, 1*/

        for (int i = 0; i < array.length - 1; i++) {

            int sumL = 0;//1       I
            int sumR = 0;//1 2 4 5 I

            for (int j = 0; j <= i; j++) {

                sumL = sumL + array[j];

            }
                    //1
            for (int k = i + 1; k < array.length; k++) {

                sumR = sumR + array[k];

            }

            if (sumL == sumR) {

                return true;

            }
        }

        return false;


    }

}