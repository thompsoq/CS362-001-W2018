package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 100 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 TimeTable timetable = new TimeTable();


		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 boolean testValid;


		 System.out.println("Start testing...");
		 GregorianCalendar cal = new GregorianCalendar(2019, 2, 17);
		 CalDay calday = new CalDay(cal);
		 try {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 LinkedList<Appt> listAppts = new LinkedList<Appt>();
				 LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
				 long randomseed = System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 int startMinute = (ValuesGenerator.RandInt(random));
				 int startHour = (ValuesGenerator.RandInt(random));

				 int startDay = (ValuesGenerator.RandInt(random) + 1);
				 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear = ValuesGenerator.RandInt(random);
				 String title = ValuesGenerator.getString(random);
				 if (title == null){
					 title = " ";
				 }
				 String description = ValuesGenerator.getString(random);
				 if (description == null){
					 description = " ";
				 }
				 //Construct a new Appointment object with the initial data

				 Appt appt = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);
				 String half = startHour > 11 ? "pm" : "am";
				 int printableHour = startHour;
				 if (printableHour > 11) {
					 printableHour -= 12;
				 }
				 if (printableHour == 0) {
					 printableHour = 12;
				 }
				 String represntationApp = printableHour + ":" + appt.getStartMinute() + half;
				 String myOutput = "\t" + startMonth + "/" + startDay + "/" + startYear + " at " + represntationApp + " ," + title + ", " + description + "\n";

				 startMinute = (ValuesGenerator.RandInt(random));
				 startHour = (ValuesGenerator.RandInt(random));
				 startDay = (ValuesGenerator.RandInt(random) + 1);
				 startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 startYear = ValuesGenerator.RandInt(random);
				 title = ValuesGenerator.getString(random);
				 if (title == null){
					 title = " ";
				 }
				 description = ValuesGenerator.getString(random);
				 if (description == null){
					 description = " ";
				 }

				 Appt appt2 = new Appt(startHour,
						 startMinute,
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);
				 half = startHour > 11 ? "pm" : "am";
				 printableHour = startHour;
				 if (printableHour > 11) {
					 printableHour -= 12;
				 }
				 if (printableHour == 0) {
					 printableHour = 12;
				 }
				 represntationApp = printableHour + ":" + appt2.getStartMinute() + half;
				 String myOutputT =  "[" + myOutput + ", " + "\t" + startMonth + "/" + startDay + "/" + startYear + " at " + represntationApp + " ," + title + ", " + description + "\n" + ", null]";


				 //Construct a new Appointment object with the initial data
				 listAppts.add(appt);
				 listAppts.add(appt2);
				 System.out.println("mtOutputT: "+ myOutputT + " to "+ listAppts.toString());
				 GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
				 GregorianCalendar tomorrow = new GregorianCalendar((startYear+1),startMonth,startDay);


				 Appt appt3 = new Appt(startHour,
						 ((startMinute+1)*70),
						 startDay,
						 startMonth,
						 startYear,
						 title,
						 description);
				 listAppts.add(appt3);

				 LinkedList<CalDay> output = timetable.getApptRange(listAppts,today,tomorrow);
				 assertEquals(myOutputT, listAppts.toString());

				 assertEquals(null, timetable.deleteAppt(listAppts2, appt3));
				 assertEquals(null, timetable.deleteAppt(listAppts, appt3));
				 assertEquals(listAppts, timetable.deleteAppt(listAppts, appt2));
				 System.out.println("deleted "+ appt2.toString());

				 assertEquals(null,	timetable.deleteAppt(listAppts2, null));
				 assertEquals(null,	timetable.deleteAppt(null, null));
				 myOutput = "[" + myOutput + ", null]";
				 assertEquals(myOutput, listAppts.toString());
				 timetable.deleteAppt(listAppts,appt);
				 System.out.println("deleted "+ appt.toString());
				 assertEquals(null,timetable.deleteAppt(listAppts,appt2));



					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("CalDay elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 } catch (NullPointerException e) {


		 }
		 System.out.println("Done testing...");
		 
	 }


	
}
