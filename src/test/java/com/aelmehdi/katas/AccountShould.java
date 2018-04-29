package com.aelmehdi.katas;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

   @Mock
   TransactionRepository transactionRepository;
   @Mock
   StatementPrinter statementPrinter;
   private Account account;

   @Before
   public void initialize() throws Exception {
      account = new Account(transactionRepository, statementPrinter);
   }

   @Test
   public void add_a_deposit_transaction() {
      account.deposit(1000);
      verify(transactionRepository).addDeposit(1000);
   }

   @Test
   public void withdraw() {
      account.withdraw(500);
      verify(transactionRepository).addWithdrawal(500);
   }

   @Test
   public void printStatement() {
      List<Transaction> transactions = asList(new Transaction("28/04/2018", 100));
      given(transactionRepository.allTransactions()).willReturn(transactions);

      account.printStatement();

      verify(statementPrinter).print(transactions);
   }

}