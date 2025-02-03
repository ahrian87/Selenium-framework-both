package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;

public class FakeDataGenerator {
    public static Faker faker;

    private static final Logger logger = LogManager.getRootLogger();

    public static String generateFakeEmail() {
        faker = new Faker();
        return faker.internet().emailAddress();
    }
}
