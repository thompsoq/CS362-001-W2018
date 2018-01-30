package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


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
	public void test03()  throws Throwable  {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay calday = new CalDay(cal);
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
		calday.addAppt(appt);
	}

//add more unit tests as you needed	
}
