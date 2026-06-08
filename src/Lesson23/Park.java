package Lesson23;


public class Park {

    public class Attraction {

        private String name;
        private String workingTime;
        private double price;

        public Attraction(String name, String workingTime, double price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingTime);
            System.out.println("Стоимость: " + price);
            System.out.println();
        }
    }
}