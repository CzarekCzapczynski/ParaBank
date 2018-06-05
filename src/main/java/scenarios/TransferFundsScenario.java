package scenarios;

import pages.AccountPage;
import pages.TransferPage;

public class TransferFundsScenario implements Scenario<AccountPage, TransferPage>{
    private String amount;
    private String fromAccountId;
    private String toAccountId;

    public TransferFundsScenario(String amount, String fromAccountId, String toAccountId) {
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public TransferPage run(AccountPage entry) {
        return entry
                .getAccountNumber(fromAccountId, 0)
                .getAccountNumber(toAccountId, 1)
                .leftMenu.clickTransferFundsLink()
                .setAmount(amount)
                .setFromAccountId(fromAccountId)
                .setToAccountId(toAccountId)
                .clickTransferButton();
    }
}
