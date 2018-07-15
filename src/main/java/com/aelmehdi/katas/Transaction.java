package com.aelmehdi.katas;

public class Transaction {
   private final String date;
   private final int amount;

   public Transaction(String date, int amount) {
      this.date = date;
      this.amount = amount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Transaction that = (Transaction) o;

      if (amount != that.amount) return false;
      return date != null ? date.equals(that.date) : that.date == null;
   }

   @Override
   public int hashCode() {
      int result = date != null ? date.hashCode() : 0;
      result = 31 * result + amount;
      return result;
   }

   public String date() {
      return date;
   }

   public int amount() {
      return amount;
   }
}
