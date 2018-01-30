package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timetable = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 int startHour=23;
		 int startMinute=30;
		 int startDay=27;
		 int startMonth=02;
		 int startYear=2019;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 Calendar rightnow = Calendar.getInstance();

		 int thisMonth = rightnow.get(Calendar.MONTH);
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 int[] recurringDays = new int[0];
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 appt.setRecurrence(recurringDays, 2, 0, 2);
		 timetable.getApptRange(listAppts, today, tomorrow);

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable timetable = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 int[] pv = new int[2];
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);
		 startHour=23;
		 startMinute=30;
		 startDay=15;
		 startMonth=01;
		 startYear=2019;
		 title="Birthday Party";
		 description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt2);
		 assertEquals(true, appt.getValid());
		 assertEquals(null, timetable.deleteAppt(listAppts, appt));
		 timetable.permute(listAppts, pv);
	 }

//add more unit tests as you needed
}
