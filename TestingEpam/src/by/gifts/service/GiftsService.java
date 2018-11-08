package by.gifts.service;

import by.gifts.dao.GiftDao;
import by.gifts.dao.ItemsDao;
import by.gifts.json.GiftJson;
import by.gifts.json.ItemsJson;
import by.gifts.model.Gifts;
import by.gifts.model.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GiftsService {
    private final Logger LOG = LoggerFactory.getLogger(GiftsService.class);
    private final ItemsService itemsService = new ItemsService();
    private final GiftDao giftDao = new GiftDao();
    private final ItemsDao itemsDao = new ItemsDao();
    private final GiftJson giftJson = new GiftJson();
    private final ItemsJson itemsJson = new ItemsJson();

    /**
     * Function that fills the {@link by.gifts.model.Gifts} and {@link Items}
     */
    public void createGift() {
        LOG.info("Start fulling gift");
        int giftWeight = 0;
        List<Items> itemsList = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(25); i++) {
            Items items = itemsService.generateItem();
            giftWeight += items.getItemWeight();
            itemsList.add(items);
            System.out.println("Item name: " + items.getItemName() + "\nItem weight: " + items.getItemWeight());
        }
        Gifts gifts = new Gifts(giftWeight);
        giftDao.createGift(gifts);
        giftJson.createGift(gifts);
        int ID = giftDao.getGiftID();
        writeItemsIntoDao(itemsList, ID);
        writeItemsIntoJson(itemsList, ID);
        LOG.info("Gift is fulled");
        System.out.println("That all! Your gift weight is: " + giftWeight);
    }

    private void writeItemsIntoJson(List<Items> itemsList, int ID) {
        List<Items> itemsListTemp = new ArrayList<>();
        itemsList.forEach(a -> itemsListTemp.add(new Items(ID, a.getItemWeight(), a.getItemName())));
        itemsJson.createItem(itemsListTemp);
    }

    private void writeItemsIntoDao(List<Items> itemsList, int ID) {
        itemsList.forEach(a -> itemsDao.createItem(new Items(ID, a.getItemWeight(), a.getItemName())));
    }
}
