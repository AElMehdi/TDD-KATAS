package com.aelmehdi.katas;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
   private Clock clock;
   private List<Transaction> transactions = new ArrayList<Transaction>();

   public TransactionRepository(Clock clock) {
      this.clock = clock;
   }

   public void addDeposit(int amount) {
      Transaction deposit = new Transaction(clock.todayAsString(), amount);
      transactions.add(deposit);
   }

   public void addWithdrawal(int amount) {
      Transaction withdraw = new Transaction(clock.todayAsString(), -amount);
      transactions.add(withdraw);
   }

   public List<Transaction> allTransactions() {
      return unmodifiableList(transactions);
   }
}
