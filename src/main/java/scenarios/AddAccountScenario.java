package scenarios;

import pages.AccountPage;
import pages.OpenAccountPage;

public class AddAccountScenario implements Scenario<AccountPage, OpenAccountPage>{

    private String accountType;
    private String fromAccountId;


    public AddAccountScenario(String accountType, String fromAccountId) {
        this.accountType = accountType;
        this.fromAccountId = fromAccountId;
    }

    public OpenAccountPage run(AccountPage entry) {
        return entry
                .getAccountNumber(fromAccountId)
                .leftMenu.clickOpenNewAccountLink()
                .setAccountType(accountType)
                .setFromAccountNumberByKey(fromAccountId)
                .clickOpenNewAccountButton();
    }
}
