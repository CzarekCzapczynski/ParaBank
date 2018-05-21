package scenarios;

import pages.OpenAccountPage;

public class AddAccountScenario implements Scenario<OpenAccountPage, OpenAccountPage>{
    private String accountType;
    private String FromAccountId;

    public AddAccountScenario(String accountType, String fromAccountId) {
        this.accountType = accountType;
        this.FromAccountId = fromAccountId;
    }

    public OpenAccountPage run(OpenAccountPage entry) {
        return entry.setAccountType(accountType)
                .setFromAccountId(FromAccountId)
                .clickOpenNewAccountButton();
    }
}
