import java.util.Arrays;

public class Lesson22Task01 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumBetween10And20(10, 10));
        printNumberSign(-12);
        System.out.println(isNegative(-5));
        printStringSeveralTimes("Nothing", 3);
        System.out.println(checkLeapYear(2000));
        invertArrayElements();
        fillArrayFrom1To100();
        multiplyNumbersLessThanSix();
        fillDiagonals();
        System.out.println(Arrays.toString(createFilledArray(3, 5)));
    }

    // Задание 1: вывести три слова в столбец.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2: проверить знак суммы двух чисел.
    public static void checkSumSign() {
        int a = 12;
        int b = -22;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 144;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 255;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumBetween10And20(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void printNumberSign(int a) {
        if (a < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printStringSeveralTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void invertArrayElements() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        System.out.print("Измененный массив (задание 10): ");
        System.out.println(Arrays.toString(array));
    }

    public static void fillArrayFrom1To100() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void multiplyNumbersLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        System.out.print("Измененный массив (задание 12): ");
        System.out.println(Arrays.toString(array));
    }

    public static void fillDiagonals() {
        int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i + j == array.length - 1) {
                    array[i][j] = 1;
                }

                System.out.print(array[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static int[] createFilledArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }
}
