package Task1;

public class MainTask1 {

    public static void main(String[] args) {

        Dog dog1 = new Dog("Сайтама");
        Dog dog2 = new Dog("Луффи");

        Cat cat1 = new Cat("Нами");
        Cat cat2 = new Cat("Микаса");
        Cat cat3 = new Cat("Нобара");

        dog1.run(300);
        dog1.run(999999999);
        dog1.swim(5);
        dog1.swim(999999999);
        dog2.run(450);
        dog2.swim(8);

        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        System.out.println();

        Bowl bowl = new Bowl(40);

        Cat[] cats = {cat1, cat2, cat3};

        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println();

        for (Cat cat : cats) {
            cat.printSatiety();
        }

        bowl.printFood();

        System.out.println();

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего кошек: " + Cat.getCatCount());
    }
}