package scenarios;

import pages.AccountPage;
import pages.OpenAccountPage;

public class AddAccountScenario implements Scenario<AccountPage, OpenAccountPage>{
    private String accountType;
    private String FromAccountId;

    public AddAccountScenario(String accountType, String fromAccountId) {
        this.accountType = accountType;
        this.FromAccountId = fromAccountId;
    }

    public OpenAccountPage run(AccountPage entry) {
        return entry
                .leftMenu.clickOpenNewAccountLink()
                .setAccountType(accountType)
                .setFromAccountId(FromAccountId)
                .clickOpenNewAccountButton();
    }
}
