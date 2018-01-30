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
		 int startMonth=01;
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
				  "a",
				  "a");
	// assertions
		 assertTrue(appt.getValid());
		 appt.setStartHour(startHour);
		 appt.setStartMinute(startMinute);
		 appt.setStartDay(startDay);
		 appt.setStartMonth(startMonth);
		 appt.setStartYear(startYear);
		 appt.setTitle(title);
		 appt.setDescription(description);

		 assertEquals(24, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 appt.setStartHour(startHour);

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
	}
//add more unit tests as you needed

}
