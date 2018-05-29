package scenarios;

import pages.TransferPage;

public class TransferFundsScenario implements Scenario<TransferPage, TransferPage>{
    private String amount;
    private int fromAccountId;
    private int toAccountId;

    public TransferFundsScenario(String amount, int fromAccountId, int toAccountId) {
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public TransferPage run(TransferPage entry) {
        return entry.setAmount(amount)
                .setFromAccountId(fromAccountId)
                .setToAccountId(toAccountId)
                .clickTransferButton();
    }
}
