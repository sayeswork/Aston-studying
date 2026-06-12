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
            System.out.println(name + " пробежала " + distance + " м.");
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
            System.out.println(name + " поела и теперь сыта.");
        } else {
            System.out.println(name + " не поела. В миске мало еды.");
        }
    }

    public void printSatiety() {
        System.out.println(name + " сыта: " + satiety);
    }

    public static int getCatCount() {
        return catCount;
    }
}