package scenarios;

import pages.IndexPage;
import pages.LookupPage;

public class ForgotPasswordScenario implements Scenario<IndexPage, LookupPage>{

    private String firstName, lastName, street, city, state, zipCode, ssn;

    public ForgotPasswordScenario(String firstName, String lastName,
                                  String street, String city, String state, String zipCode, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.ssn = ssn;
    }

    public LookupPage run(IndexPage entry) {
        return entry.openIndexPage()
                .clickForgotLoginInfoLink()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setSsn(ssn)
                .clickFindMyLoginInfoButton();
    }
}
