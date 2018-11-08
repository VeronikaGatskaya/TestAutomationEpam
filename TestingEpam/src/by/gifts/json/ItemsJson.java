package by.gifts.json;

import by.gifts.model.Items;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ItemsJson {
    private final Logger LOG = LoggerFactory.getLogger(GiftJson.class);

    public void createItem(List<Items> items) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileOutputStream(String.valueOf(ClassLoader.getSystemResource("Items.json").toURI().getPath())), items);
        } catch (IOException | URISyntaxException e) {
            LOG.error("File items.json not found!");
        }
    }
}
