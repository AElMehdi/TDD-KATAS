package com.aelmehdi.katas;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

   @Mock Console console;
   private static final List<Transaction> NO_TRANSACTION = EMPTY_LIST;
   private StatementPrinter statementPrinter;

   @Before
   public void initialize() throws Exception {
      statementPrinter = new StatementPrinter(console);
   }

   @Test
   public void always_print_the_header() {
      statementPrinter.print(NO_TRANSACTION);

      verify(console).printLine("DATE | AMOUNT | BALANCE");
   }

   @Test
   public void print_all_transactions_in_reverse_chronological_order() {
      List<Transaction> transactions = transactionsContainer(
            deposit("20/04/2018", 1000),
            deposit("23/04/2018", 2000),
            withdrawal("29/04/2018", 500));

      statementPrinter.print(transactions);

      InOrder inOrder = inOrder(console);

      inOrder.verify(console).printLine("29/04/2018 | -500 | 2500");
      inOrder.verify(console).printLine("23/04/2018 | 2000 | 3000");
      inOrder.verify(console).printLine("20/04/2018 | 1000 | 1000");
   }

   private List<Transaction> transactionsContainer(Transaction... transactions) {
      return asList(transactions);
   }

   private Transaction withdrawal(String date, int amount) {
      return new Transaction(date, -amount);
   }

   private Transaction deposit(String date, int amount) {
      return new Transaction(date, amount);
   }
}