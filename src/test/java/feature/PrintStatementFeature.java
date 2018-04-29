package feature;

import static org.mockito.Mockito.inOrder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.aelmehdi.katas.Account;
import com.aelmehdi.katas.Clock;
import com.aelmehdi.katas.Console;
import com.aelmehdi.katas.StatementPrinter;
import com.aelmehdi.katas.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {


   @Mock
   Console console;
   @Mock
   private Clock clock;
   private Account account;

   @Before
   public void initialize() {
      TransactionRepository transactionRepository = new TransactionRepository(clock);
      StatementPrinter statementPrinter = new StatementPrinter();
      account = new Account(transactionRepository, statementPrinter);
   }

   @Test
   public void should_print_all_account_transactions() {
      account.deposit(1000);
      account.deposit(2000);
      account.withdraw(500);

      account.printStatement();

      InOrder inOrder = inOrder(console);

      inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
      inOrder.verify(console).printLine("20/04/2018 | -500 | 2500");
      inOrder.verify(console).printLine("20/04/2018 | 2000 | 3000");
      inOrder.verify(console).printLine("20/04/2018 | 1000 | 1000");
   }
}




