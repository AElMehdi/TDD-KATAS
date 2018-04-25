#Bank Kata following an *Outside In TDD* approach
##Steps
1.Write an acceptance test
  1. Identify the side effect, in our case (printing all the account transactions)
  2. Mock the external world (the console in this simple example), and use the real implementation of your system's classes
  3. Identify the trigger (the account printStatement method)