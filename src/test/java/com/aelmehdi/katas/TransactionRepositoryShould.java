package com.aelmehdi.katas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

   @Mock
   Clock clock;

   private static final String TODAY = "28/04/2018";
   private TransactionRepository transactionRepository;

   @Before
   public void initialize() {
      transactionRepository = new TransactionRepository(clock);
      given(clock.todayAsString()).willReturn(TODAY);
   }

   @Test
   public void add_a_deposit_transaction() {
      transactionRepository.addDeposit(100);

      List<Transaction> transactions = transactionRepository.allTransactions();

      assertThat(transactions.size()).isEqualTo(1);
      assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, 100));
   }

   @Test
   public void add_a_withdrawal_transaction() {
      transactionRepository.addWithdrawal(200);

      List<Transaction> transactions = transactionRepository.allTransactions();

      assertThat(transactions.size()).isEqualTo(1);
      assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, -200));
   }

   private Transaction transaction(String date, int amount) {
      return new Transaction(date, amount);
   }

}