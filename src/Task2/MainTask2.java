package Task2;

public class MainTask2 {

    public static void main(String[] args) {

        Circle circle = new Circle(5, "Красный", "Черный");

        Rectangle rectangle = new Rectangle(4, 7, "Синий", "Белый");

        Triangle triangle = new Triangle(6, 5, 5, 4, "Зеленый", "Желтый");

        circle.printInfo();

        rectangle.printInfo();

        triangle.printInfo();
    }
}