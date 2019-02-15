package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
         // set up array of LocalDates to hold full moons for 2019
        LocalDate[] fullMoon =
                {LocalDate.of(2019,1,21), LocalDate.of(2019,2,19),
                LocalDate.of(2019,3,20), LocalDate.of(2019,4,19),
                LocalDate.of(2019,5,18), LocalDate.of(2019,6,17),
                LocalDate.of(2019,7,16), LocalDate.of(2019,8,15),
                LocalDate.of(2019,9,14), LocalDate.of(2019,10,13),
                LocalDate.of(2019,11,12), LocalDate.of(2019,12,12)};

        // get current date
        LocalDate today = LocalDate.now();

        // set date time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yy");

        // format current date
        String sToday = today.format(formatter);

/*  --------------------------------------------------------------------------------------------------------------  */

//        for(int i = 0; i < fullMoon.length; i++){
//            String sDay = fullMoon[i].format(formatter);
//            System.out.println(sDay);
//        }

        // compareTo returns a positive number if the today date is after the compareTo date.
        // it returns a negative number if the today date is before the campareTo date.
        // the value of the number signifies how much before or after
        // so comparing feb 15th to nov 11th gets a return of -9 but to april 19th only gets -2
        // System.out.println(today.compareTo(fullMoon[3]));

/*  --------------------------------------------------------------------------------------------------------------  */

        // print today's date
        System.out.println("Today is: " + sToday);

        // test check for date
        // today = LocalDate.of(2019, 7, 18);

        // local variable to hold the date of the next full moon
        LocalDate next = fullMoon[0];

        // count control
        int d = 0;

        // for each to loop through fullMoon
        for(LocalDate x : fullMoon)
        {
            if(today.compareTo(next) > 0)
            {
                d++;
                next = fullMoon[d];
            }
            else
            {
                System.out.println("The next full moon is on: " + next.format(formatter));
                System.out.println("That is " + today.until(next, ChronoUnit.DAYS) + " days away.");
                break;
            }
        }

        // This is why I don't like the for-each loop, if this was done in a C style for loop I wouldn't need that extra
        // variable.

    }
}
