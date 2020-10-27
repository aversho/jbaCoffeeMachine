package machine;

public class Resources {
    private int water;
    private int beans;
    private int milk;
    private int cups;
    private double money;

    public Resources() {
        this(0, 0, 0);
    }

    public Resources(int water, int beans) {
        this(water, beans, 0);
    }

    public Resources(int water, int beans, int milk) {
        this(water, beans, milk, 0, 0);
    }

    public Resources(int water, int beans, int milk, int cups, double money) {
        this.milk = Math.max(milk, 0);
        this.water = Math.max(water, 0);
        this.beans = Math.max(beans, 0);
        this.money = money;
        this.cups = Math.max(cups, 0);
    }

    public void spend(Resources resources) {
        beans -= resources.beans;
        milk -= resources.milk;
        water -= resources.water;
        money -= resources.money;
        cups -= resources.cups;
    }

    public void add(Resources resources) {
        beans += resources.beans;
        milk += resources.milk;
        water += resources.water;
        cups += resources.cups;
        money += resources.money;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getBeans() {
        return beans;
    }

    public long getMoney() {
        return (long)money;
    }

    public int getCups() {
        return cups;
    }
}
