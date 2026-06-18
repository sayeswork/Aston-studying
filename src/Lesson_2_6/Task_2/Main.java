package Lesson_2_6.Task_2;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Бэггинс", "111-11-11");
        phoneBook.add("Гэмджи", "222-22-22");
        phoneBook.add("Бэггинс", "333-33-33");

        System.out.println("Бэггинс: " + phoneBook.get("Бэггинс"));
        System.out.println("Гэмджи: " + phoneBook.get("Гэмджи"));
        System.out.println("Брендибак: " + phoneBook.get("Брендибак"));
    }
}
