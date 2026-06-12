package Task1;

public class Cat extends Animal {

    private static int catCount = 0;

    private boolean satiety;

    public Cat(String name) {
        super(name);
        catCount++;
        satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.takeFood(amount)) {
            satiety = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не поел. В миске мало еды.");
        }
    }

    public void printSatiety() {
        System.out.println(name + " сыт: " + satiety);
    }

    public static int getCatCount() {
        return catCount;
    }
}