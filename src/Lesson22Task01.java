import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class Lesson22Task01 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumBetween10And20(10, 10));
        printNumberSign(-12);
        System.out.println(checknuNumberSign(-5));
        printStringSeveralTimes("Hello", 3);
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
    //Задание 3:
    public static void printColor() {
        int value = 144;
        if (value <=0) {
            System.out.println("Красный");
        }
        else if (value < 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = 255;
        int b = 15;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else if (a < b) {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumBetween10And20(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <=20) {
            return true;
        }
        else {
            return false;

        }

    }public static void printNumberSign(int a) {
        if (a < 0) {
            System.out.println("Отрицательное число");
        }
        else {
            System.out.println("Положительное число");
        }
    }
    public static boolean checknuNumberSign(int a) {
        if (a < 0) {
            return true;}
        else {
            return false;
        }
    }

    public static void printStringSeveralTimes(String text, int count) {
        for (int i = count; i > 0; i--) {
        System.out.println(text);
        };
    }

}
