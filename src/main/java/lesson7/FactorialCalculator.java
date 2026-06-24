package lesson7;

public class FactorialCalculator {

    public long calculate(int number) {
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
