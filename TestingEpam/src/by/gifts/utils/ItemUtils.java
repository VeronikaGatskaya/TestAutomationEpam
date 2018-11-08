package by.gifts.utils;

import java.util.Random;

public class ItemUtils {
    /**
     *
     * @return {@link String} name of item
     */
    public String generateItemName() {
        String[] items = {"Sweet", "Waffles", "Chocolate bar", "Fruit"};
        return items[new Random().nextInt(items.length)];
    }

    /**
     *
     * @return {@link Double} weight of item
     */
    public double generateItemWeight() {
        return 0 + Math.random() * 30;
    }
}
