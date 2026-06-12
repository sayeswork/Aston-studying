package Task2;

public class MainTask2 {

    public static void main(String[] args) {

        Circle circle = new Circle(4, "Лазурный", "Графитовый");

        Rectangle rectangle = new Rectangle(6, 9, "Изумрудный", "Серебристый");

        Triangle triangle = new Triangle(800, 500, 500, 300, "Аметистовый", "Золотой");

        circle.printInfo();

        rectangle.printInfo();

        triangle.printInfo();
    }
}