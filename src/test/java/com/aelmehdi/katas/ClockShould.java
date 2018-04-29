package com.aelmehdi.katas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import org.junit.Test;

public class ClockShould {

   @Test
   public void return_date_in_dd_MM_yyyy_format() {
      Clock clock = new TestableClock();

      String today = clock.todayAsString();

      assertThat(today).isEqualTo("28/04/2018");
   }


   private class TestableClock extends Clock {
      @Override
      protected LocalDate today() {
         return LocalDate.of(2018, 04, 28);
      }
   }
}