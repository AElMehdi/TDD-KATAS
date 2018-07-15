package com.aelmehdi.katas;

public class BankataApp {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        StatementPrinter statementPrinter = new StatementPrinter(new Console());
        Account account = new Account(transactionRepository, statementPrinter);


        account.deposit(500);
        account.deposit(1000);
        account.withdraw(200);

        account.printStatement();
    }
}
