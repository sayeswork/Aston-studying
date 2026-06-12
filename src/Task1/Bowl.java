package Task1;

public class Bowl {

    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean takeFood(int amount) {
        if (food >= amount) {
            food = food - amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        food = food + amount;
    }

    public void printFood() {
        System.out.println("В миске осталось еды: " + food);
    }
}