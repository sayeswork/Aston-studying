package Lesson23;


public class Main {

    public static void main(String[] args) {

        System.out.println("Задание 2. Массив товаров");
        System.out.println();

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );

        productsArray[1] = new Product(
                "iPhone 16 Pro",
                "15.01.2025",
                "Apple Inc.",
                "USA",
                6299,
                false
        );

        productsArray[2] = new Product(
                "Xiaomi 15",
                "20.03.2025",
                "Xiaomi",
                "China",
                3299,
                true
        );

        productsArray[3] = new Product(
                "Sony PlayStation 5",
                "10.12.2024",
                "Sony",
                "Japan",
                2499,
                false
        );

        productsArray[4] = new Product(
                "LG OLED TV",
                "05.11.2024",
                "LG Electronics",
                "Korea",
                4999,
                true
        );

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
        }

        System.out.println("Задание 3. Парк и аттракционы");
        System.out.println();

        Park park = new Park();

        Park.Attraction ferrisWheel = park.new Attraction(
                "Колесо обозрения",
                "10:00 - 22:00",
                350
        );

        Park.Attraction rollerCoaster = park.new Attraction(
                "Американские горки",
                "11:00 - 21:00",
                500
        );

        ferrisWheel.printInfo();
        rollerCoaster.printInfo();
    }
}