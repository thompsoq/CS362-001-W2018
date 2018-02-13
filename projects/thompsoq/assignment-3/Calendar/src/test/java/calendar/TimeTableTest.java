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

		//Generate Appointments
		int startHour=23;
		int startMinute=30;
		int startDay=27;
		int startMonth=02;
		int startYear=2019;

		String title="Birthday Party1";
		String description="This is my birthday party.1";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		listAppts.add(appt);

		startHour=21;
		startMinute=30;
		startDay=27;
		startMonth=02;
		startYear=2019;

		title="Birthday Party2";
		description="This is my birthday party.2";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		listAppts.add(appt2);

		startHour=21;
		startMinute=30;
		startDay=28;
		startMonth=02;
		startYear=2019;

		title="Birthday Party3";
		description="This is my birthday party.3";
		//Construct a new Appointment object with the initial data
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		listAppts.add(appt3);

		startHour=21;
		startMinute=30;
		startDay=28;
		startMonth=05;
		startYear=2019;

		title="Birthday Party3";
		description="This is my birthday party.3";
		//Construct a new Appointment object with the initial data
		Appt appt4 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		listAppts.add(appt4);

		int[] recurringDays1 = new int[0];
		int recurringDays2[] = {0,1,3,4};

		GregorianCalendar today = new GregorianCalendar(2019,2,27);
		GregorianCalendar tomorrow = new GregorianCalendar(2019,2,29);
		appt.setRecurrence(recurringDays2, 1, 1, 1);
		LinkedList<CalDay> output = timetable.getApptRange(listAppts,today,tomorrow);
		String myString = "[\t --- 2/27/2019 --- \n --- -------- Appointments ------------ --- \n\t2/27/2019 at 9:30pm ,Birthday Party2, This is my birthday party.2\n \t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n \n, \t --- 2/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n\t2/28/2019 at 9:30pm ,Birthday Party3, This is my birthday party.3\n \n]";
		assertEquals(myString, output.toString());


		LinkedList<Appt> listAppts2 = new LinkedList<Appt>();

		Appt appt5 = new Appt(startHour,
				70 ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		listAppts.add(appt5);
		assertEquals(null, timetable.deleteAppt(listAppts2, appt5));
		assertEquals(null, timetable.deleteAppt(listAppts, appt5));
		assertEquals(listAppts, timetable.deleteAppt(listAppts, appt3));
		assertEquals(null,	timetable.deleteAppt(listAppts2, null));
		assertEquals(null,	timetable.deleteAppt(null, null));
		myString = "[\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				", \t2/27/2019 at 9:30pm ,Birthday Party2, This is my birthday party.2\n" +
				", \t5/28/2019 at 9:30pm ,Birthday Party3, This is my birthday party.3\n" +
				", null]";
		assertEquals(myString, listAppts.toString());
		timetable.deleteAppt(listAppts,appt);
		timetable.deleteAppt(listAppts,appt2);
		timetable.deleteAppt(listAppts,appt3);
		timetable.deleteAppt(listAppts,appt4);
		assertEquals(null,timetable.deleteAppt(listAppts,appt4));
	}
	@Test
	public  void test03()	throws Throwable{
		TimeTable timetable = new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		int[] recurringDays1 = {};
		int[] recurringDays2 = {0,1,3,4};
		int startHour=23;
		int startMinute=30;
		int startDay=27;
		int startMonth=02;
		int startYear=2019;
		String title="Birthday Party1";
		String description="This is my birthday party.1";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt.setRecurrence(recurringDays2, 1, 1, 3);
		listAppts.add(appt);
		title="Birthday Party2";
		description="This is my birthday party.2";
		//Construct a new Appointment object with the initial data

		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt2.setRecurrence(recurringDays1, 1, 1, 3);
		listAppts.add(appt2);
		title="Birthday Party3";
		description="This is my birthday party.3";
		//Construct a new Appointment object with the initial data
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt3.setRecurrence(recurringDays2, 1, 1, 3);
		listAppts.add(appt3);
		title="Birthday Party3";
		description="This is my birthday party.3";
		//Construct a new Appointment object with the initial data
		Appt appt4 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		listAppts.add(appt4);
		appt4.setRecurrence(recurringDays2, 2, 1, 3);

		String mystring = "[\t --- 2/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party2, This is my birthday party.2\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \n" +
				", \t --- 2/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \n" +
				", \t --- 3/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \n" +
				", \t --- 3/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party2, This is my birthday party.2\n" +
				" \t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \n" +
				", \t --- 3/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party2, This is my birthday party.2\n" +
				" \n" +
				", \t --- 3/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party2, This is my birthday party.2\n" +
				" \n" +
				", \t --- 3/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party3, This is my birthday party.3\n" +
				" \n" +
				"]";
		GregorianCalendar today = new GregorianCalendar(2019,2,27);
		GregorianCalendar tomorrow = new GregorianCalendar(2019,3,28);


		timetable.getApptRange(listAppts, today, tomorrow);
		assertEquals(mystring, timetable.getApptRange(listAppts, today, tomorrow).toString());

		int[] recurringDays3 = {8};
		Appt appt5 = new Appt(startHour,
				startMinute ,
				42 ,
				startMonth ,
				startYear ,
				title,
				description);
		appt4.setRecurrence(recurringDays3, 4, 1, 3);
		listAppts.add(appt5);

		today = new GregorianCalendar(2019,2,1);
		tomorrow = new GregorianCalendar(2019,2,2);
		timetable.getApptRange(listAppts, today, tomorrow);
		mystring = "[\t --- 2/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				"]";
		assertEquals(mystring, timetable.getApptRange(listAppts, today, tomorrow).toString());

	}

	@Test
	public void test04() throws Throwable{
		TimeTable timetable = new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		int[] recurringDays1 = {};
		int[] recurringDays2 = {0,1,3,4};
		int startHour=23;
		int startMinute=30;
		int startDay=27;
		int startMonth=02;
		int startYear=2019;
		String title="Birthday Party1";
		String description="This is my birthday party.1";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		appt.setRecurrence(recurringDays1, 3, 1, 2);
		listAppts.add(appt);
		GregorianCalendar today = new GregorianCalendar(2019,2,27);
		GregorianCalendar tomorrow = new GregorianCalendar(2020,3,4);
		String mystring = "[\t --- 2/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \n" +
				", \t --- 2/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 4/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 5/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 6/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 7/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 8/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 9/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 10/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/1/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/2/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/3/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/4/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/5/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/6/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/7/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/8/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/9/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/10/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/11/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/12/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/13/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/14/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/15/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/16/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/17/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/18/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/19/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/20/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/21/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/22/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/23/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/24/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/25/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/26/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/27/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/28/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/29/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/30/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 11/31/2019 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/1/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/2/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/3/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/4/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/5/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/6/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/7/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/8/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/9/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/10/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/11/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/12/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/13/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/14/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/15/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/16/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/17/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/18/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/19/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/20/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/21/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/22/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/23/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/24/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/25/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/26/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/27/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/28/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/29/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/30/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 0/31/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/1/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/2/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/3/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/4/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/5/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/6/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/7/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/8/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/9/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/10/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/11/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/12/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/13/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/14/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/15/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/16/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/17/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/18/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/19/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/20/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/21/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/22/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/23/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/24/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/25/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/26/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/27/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/28/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 1/29/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/1/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/2/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/3/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/4/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/5/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/6/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/7/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/8/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/9/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/10/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/11/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/12/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/13/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/14/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/15/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/16/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/17/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/18/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/19/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/20/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/21/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/22/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/23/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/24/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/25/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/26/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/27/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t2/27/2019 at 11:30pm ,Birthday Party1, This is my birthday party.1\n" +
				" \n" +
				", \t --- 2/28/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/29/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/30/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 2/31/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/1/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/2/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				", \t --- 3/3/2020 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\n" +
				"]";
		assertEquals(mystring, timetable.getApptRange(listAppts, today, tomorrow).toString());
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