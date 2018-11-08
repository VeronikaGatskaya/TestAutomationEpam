package by.gifts;

import by.gifts.service.GiftsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final GiftsService giftsService = new GiftsService();

    public static void main(String[] args) {
        showMessages();
        runCommand();
    }

    private static void runCommand() {
        try {
            switch (Objects.requireNonNull(new BufferedReader(new InputStreamReader(System.in)).readLine().toLowerCase())) {
                case "yes":
                    giftsService.createGift();
                    break;
                default:
                    LOG.debug("Program has stop the work due to default input!");
                    System.exit(2);
                    break;
            }
        } catch (IOException e) {
            LOG.debug("Program has stop the work due to exception!");
            LOG.error("Exception: " + e.toString());
        }
    }

    private static void showMessages() {
        LOG.info("Program started");
        System.out.println("Hello, u wanna get some gift?");
        System.out.println("Type 'Yes' if u wanna that or type 'No' if u won't");
    }
}
