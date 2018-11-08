package by.gifts.json;

import by.gifts.model.Gifts;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileOutputStream;
import java.io.IOException;

public class GiftJson {
    private final Logger LOG = LoggerFactory.getLogger(GiftJson.class);

    public void createGift(Gifts gifts) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileOutputStream(ClassLoader.getSystemResource("Gifts.json").getPath()), gifts);
        } catch (IOException e) {
            LOG.error("File gifts.json not found!");
        }
    }
}
