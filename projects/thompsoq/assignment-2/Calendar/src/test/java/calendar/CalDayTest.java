package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);
		assertEquals(true, calday.isValid());
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		assertEquals(thisDay, calday.getDay());
		assertEquals(thisMonth, calday.getMonth());
		assertEquals(thisYear, calday.getYear());
		String stringday = "\t --- " + thisMonth + "/" + thisDay + "/" + thisYear + " --- \n --- -------- Appointments ------------ --- \n";
		assertEquals(stringday, calday.toString());

	}

	@Test
	public void test02()  throws Throwable  {
		CalDay caldayfalse = new CalDay();
		assertEquals(null, caldayfalse.iterator());
	}

	@Test
	public void test03()  throws Throwable {
		GregorianCalendar cal = new GregorianCalendar(2019,2,17);

		int startHour = 21;
		int startMinute = 30;
		int startDay = 27;
		int startMonth = 02;
		int startYear = 2019;
		CalDay calday = new CalDay(cal);
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				"second",
				"I am second");
		calday.addAppt(appt2);

		startHour = 16;
		//Construct a new Appointment object with the initial data
		Appt appt3 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				"first",
				"I am first");
		calday.addAppt(appt3);
		assertEquals("\t --- 2/17/2019 --- \n --- -------- Appointments ------------ --- \t2/27/2019 at 4:30pm ,first, I am first\n \t2/27/2019 at 9:30pm ,second, I am second\n \n", calday.toString());

		assertEquals(2, calday.getSizeAppts());
		calday.iterator();
	}

//add more unit tests as you needed
}