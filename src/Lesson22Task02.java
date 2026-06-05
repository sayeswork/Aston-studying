public class Lesson22Task02 {
    public static void main(String[] args) {
        checkSumSign();
    }

    // Zadanie 2: proverit znak summy dvuh chisel.
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
}
