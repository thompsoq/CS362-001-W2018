package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01()  throws Throwable  {
		int startHour=24;
		int startMinute=30;
		int startDay=15;
		int startMonth=02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(//startHour,
				0,//0,
				0, //
				1, //0, //
				1 , //0, //
				1997 , //"a",
				"",
				"");
		// assertions

		assertTrue(appt.getValid());
		appt.setStartHour(70);
		assertFalse(appt.getValid());
		appt.setStartHour(-1);
		assertFalse(appt.getValid());
		appt.setStartHour(23);
		assertTrue(appt.getValid());


		appt.setStartMinute(100);
		assertFalse(appt.getValid());
		appt.setStartMinute(-1);
		assertFalse(appt.getValid());
		appt.setStartMinute(60);
		assertFalse(appt.getValid());
		appt.setStartMinute(0);
		assertTrue(appt.getValid());
		appt.setStartMinute(1);
		assertTrue(appt.getValid());
		appt.setStartMinute(59);
		assertTrue(appt.getValid());


		appt.setStartDay(100);
		assertFalse(appt.getValid());
		appt.setStartDay(17);
		assertTrue(appt.getValid());
		appt.setStartDay(-1);
		assertFalse(appt.getValid());

		appt.setStartHour(startHour);
		appt.setStartMinute(startMinute);
		appt.setStartDay(startDay);
		appt.setStartMonth(startMonth);
		appt.setStartYear(startYear);
		appt.setTitle(null);
		appt.setDescription(null);
		appt.setTitle(title);
		appt.setDescription(description);


		assertEquals(24, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(02, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

		assertEquals(0, appt.compareTo(appt));
		Appt appt2 = new Appt(//startHour,
				23,
				30,
				15,
				2 ,
				2018 ,
				"Birthday Party",
				"This is my birthday party");
		assertEquals(1, appt.compareTo(appt2));
		appt2.setStartMinute(29);
		assertEquals(2, appt.compareTo(appt2));
		appt2.setStartDay(14);
		assertEquals(3, appt.compareTo(appt2));
		appt2.setStartMonth(1);
		assertEquals(4, appt.compareTo(appt2));
		appt2.setStartYear(2017);
		assertEquals(5, appt.compareTo(appt2));
	}

	@Test
	public void test02()  throws Throwable  {
		int startHour=21;
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
		// assertions
		int RECUR_BY_MONTHLY = 2;
		int RECUR_NUMBER_NEVER = 0;
		int[] recurringDays = new int[0];
		appt.setRecurrence(recurringDays, RECUR_BY_MONTHLY, 0, RECUR_NUMBER_NEVER);
		assertEquals(RECUR_BY_MONTHLY, appt.getRecurBy());
		assertEquals(recurringDays, appt.getRecurDays());
		assertEquals(false, appt.isRecurring());
		assertEquals(0, appt.getRecurIncrement());
		appt.setRecurrence(null, RECUR_BY_MONTHLY, 1, 1);
		assertEquals(RECUR_BY_MONTHLY, appt.getRecurBy());
		assertEquals(true, appt.isRecurring());
		assertEquals(1, appt.getRecurIncrement());
	}
	@Test
	public void test3()  throws Throwable  {
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(1,
				100 ,
				1 ,
				1 ,
				2900 ,
				"a",
				"a");
		// assertions
		assertEquals(null, appt.toString());

	}

	@Test
	public void test4()  throws Throwable  {
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
		// assertions
		assertEquals("\t1/15/2018 at 11:30pm ,Birthday Party, This is my birthday party.\n" , appt.toString());
		appt.setStartHour(0);
		assertEquals("\t1/15/2018 at 12:30am ,Birthday Party, This is my birthday party.\n" , appt.toString());
		appt.setStartHour(11);
		assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n" , appt.toString());
		appt.setStartHour(13);
		assertEquals("\t1/15/2018 at 1:30pm ,Birthday Party, This is my birthday party.\n" , appt.toString());
	}

//add more unit tests as you needed

}
