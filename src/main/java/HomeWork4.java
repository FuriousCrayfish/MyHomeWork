import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    static final char DOT_AI = '0'; // Фишка игрока - компьютер
    static final char DOT_EMPTY = '*'; // Признак пустого поля
    static final Scanner scanner = new Scanner(System.in); // Вспомогательный класс для ввода данных
    static final Random random = new Random(); // Вспомогательный класс для генерации случайных чисел
    static char[][] field; // Двумерный массив, хранит текущее состояние игрового поля
    static int fieldSizeX; // Размерность игрового поля
    static int fieldSizeY; // размерность игрового поля

    //TODO: Использовать в домашнем задании
    static final int WIN_COUNT = 3;


    /**
     * Инициализация объектов игры
     */
    private static void initialize(){
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    static void printField(){

        System.out.print("+");
        for (int i = 0; i < fieldSizeX*2 + 1; i++){
            /*if (i % 2 == 0){
                System.out.print('-');
            }
            else {
                int a = i / 2 + 1;
                System.out.print(a);
            }*/
            // if - then - else
            System.out.print(i % 2 == 0 ? "-" : i/2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX*2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    static void humanTurn(){
        int x, y;

        do{
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел >>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        }while (!(isCellValid(x, y) && isCellEmpty(x, y)));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода игрока (компьютер)
     */
    static void aiTurn(){
        int x, y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while(!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода (координаты хода не должны превышать размерность
     * массива, описывающего игровое поле)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y)
    {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * проверка победы игрока (человек/компьютер)
     * @param
     * @return
     */
    //TODO Переработоать этот метод, сделать универсальным, цикл for


    static boolean checkLanes(char symb, int offsetX, int offsetY) {
        boolean cols, rows;
        for (int col=offsetX; col<WIN_COUNT+offsetX; col++) {
            cols = true;
            rows = true;
            for (int row=offsetY; row<WIN_COUNT+offsetY; row++) {
                cols &= (field[col][row] == symb);
                rows &= (field[row][col] == symb);
            }

            if (cols || rows) return true;
        }

        return false;
    }

    /** Проверяем диагонали */
    static boolean checkDiagonal(char symb, int offsetX, int offsetY) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<4; i++) {
            toright &= (field[i][i] == symb);
            toleft &= (field[4-i-1][i] == symb);
            for (int row=offsetY; row<WIN_COUNT+offsetY; row++) {
                toright &= (field[offsetX][row] == symb);
                toright &= (field[row][offsetX] == symb);
            }
        }

        if (toright || toleft) return true;

        return false;
    }

    static boolean checkWin(char symb) {
        for (int col=0; col<3; col++) {
            for (int row=0; row<3; row++) {
                // Вызываем методы проверки и если хоть один блок заполнен,
                // то игрок, который проставляет это символ, выиграл
                // иначе продолжаем для другого смещения
                if (checkDiagonal(symb, col, row) || checkLanes(symb, col, row)) return true;
            }
        }
        // Все подквадраты в квадрате проверены. 4-х последовательностей
        // подряд не выявлено. Значит еще не победа.
        return false;
    }


    /*static boolean checkWinnerHorizontal() {
        for (int x = 0; x < fieldSizeX; x++) {
            boolean res = true;
            for (int x = 1; x < fieldSizeX && res; x++)
                res = field[x][x] == field[x][0];
            if (res)
                return true;
        }
        return false;
    }

    static boolean checkWinnerVertical() {
        for (int x = 0; x < fieldSizeX; x++) {
            boolean res = true;
            for (int y = 1; y < fieldSizeY && res; y++)
                res = field[y][x] == field[0][x];
            if (res)
                return true;
        }
        return false;
    }

    static boolean checkWinnerDiagonals() {
        boolean res = true;

        for (int x = 1; y < fieldSizeY && res; x++)
            res = field[x][x] == field[0][0];
        if (res)
            return true;
        res = true;
        for (int x = 1; y < fieldSizeX && res; x++)
            res = field[fieldSizeX - x - 1][x] == field[fieldSizeY - 1][0];
        return res;
    }/*

   /* static boolean checkWin(char c){

       //проверка по трем горизонталям
        if(field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if(field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if(field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        //проверка по трем вертикалям
        if(field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if(field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if(field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        //проверка по двум диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;

    }*/

    /**
     * проверка на ничью (не осталось пустых полей)
     * @return
     */
    static boolean checkDraw(){

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }

        }
        return true;

    }

    /**
     * метод проверки состояния игры
     * @param dot игровая фишка
     * @param s победный слоган
     * @return
     */
    static boolean gameChecks(char dot, String s){

        if(checkWin(dot)){
            System.out.println(s);
            return true;// завершение игры
        }
        if (checkDraw()){
            System.out.println("У вас ничья");
            return true;//завершение игры
        }
        return false;// продолжаем игру
    }


    public static void main(String[] args) {

        while (true){

            initialize();
            printField();

            while(true){
                humanTurn();//обработка хода игрока
                printField();
                if (gameChecks(DOT_HUMAN, "Вы победили, поздравляю!"))
                    break;
                aiTurn();//Обработка хода компьютера
                printField();
                if (gameChecks(DOT_AI, "Вы проиграли, сожалею!"))
                    break;

            }

            System.out.print("Хотите сыграть еще? ( y - да)");
            if (!scanner.next().equalsIgnoreCase("y"))
                break;

        }

    }

}
