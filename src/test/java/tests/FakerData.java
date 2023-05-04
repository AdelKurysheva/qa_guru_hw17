package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {
    public static Faker faker = new Faker(new Locale("en"));
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            subject = faker.options().option("English", "Physics", "Civics", "Chemistry"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            picture = "test.png",
            currentAddress = faker.harryPotter().spell(),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March",
                    "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2022)),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = city();

    public static String city() {
        if (state.equals("NCR")) {
            String city = faker.options().option("Delhi", "Gurgaon", "Noida");
            return city;
        } else if (state.equals("Uttar Pradesh")) {
            String city = faker.options().option("Agra", "Lucknow", "Merrut");
            return city;
        } else if (state.equals("Haryana")) {
            String city = faker.options().option("Karnal", "Panipat");
            return city;
        } else if (state.equals("Rajasthan")) {
            String city = faker.options().option("Jaipur", "Jaiselmer");
            return city;
        }
        return "";

    }
}
