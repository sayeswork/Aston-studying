package Lesson_2_5;

public class Main {

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Сумма массива = " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали ArrayIndexOutOfBoundsException");
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }

            for (int j = 0; j < array[i].length; j++) {

                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}