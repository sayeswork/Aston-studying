package lesson7;

public class NumberComparator {

    public int compare(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return 1;
        }
        if (firstNumber < secondNumber) {
            return -1;
        }
        return 0;
    }
}
