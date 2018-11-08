package by.gifts.service;

import by.gifts.model.Items;
import by.gifts.utils.ItemUtils;

public class ItemsService {
    private final ItemUtils itemUtils = new ItemUtils();

    /**
     * Function generates items of gift
     * @return fulled object {@link Items}
     */
    public Items generateItem() { return new Items(itemUtils.generateItemWeight(), itemUtils.generateItemName());
    }
}
