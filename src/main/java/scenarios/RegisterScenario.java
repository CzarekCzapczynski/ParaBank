package scenarios;

import pages.AccountPage;
import pages.IndexPage;
import pages.RegisterSuccessfulPage;

public class RegisterScenario implements Scenario <IndexPage, RegisterSuccessfulPage> {

    private String firstName, lastName, street, city, state, zipCode, ssn, username, password, repeatedPassword;

    public RegisterScenario(String firstName, String lastName, String street, String city, String state, String zipCode,
                            String ssn, String username, String password, String repeatedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public RegisterSuccessfulPage run(IndexPage entry) {
        return entry.openIndexPage()
                .clickRegisterLink()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setSsn(ssn)
                .setUsername(username)
                .setPassword(password)
                .setRepeatedPassword(repeatedPassword)
                .clickRegisterButton();
    }
}
