package machine;

public enum Drinks {
    ESPRESSO(new Resources(250, 16, 0, 1, -4)),
    LATTE(new Resources(350, 20, 75, 1, -7)),
    CAPPUCCINO(new Resources(200, 12, 100, 1, -6));

    Resources resources;

    Drinks(Resources resources) {
        this.resources = resources;
    }

    public Resources getResources() {
        return resources;
    }

    public String getDescription() {
        return this.name().toLowerCase();
    }

    public static String getDrinksDescription() {
        StringBuilder description = new StringBuilder();
        int index = 1;
        for (Drinks drink : Drinks.values()) {
            description.append(index++).append(" - ").append(drink.name().toLowerCase()).append(", ");
        }
        description.replace(description.length() - 2, description.length(),"");
        return description.toString();
    }
}
