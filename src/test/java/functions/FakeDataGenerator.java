package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;

public class FakeDataGenerator {
    public static Faker faker = new Faker();

    private static final Logger logger = LogManager.getRootLogger();

    public static String generateFakeEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateFakePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }
}
