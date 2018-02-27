package calendar;


import org.junit.Test;


import java.util.Calendar;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 100 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void radnomtest() throws Throwable {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		boolean testValid;






		System.out.println("Start testing...");
		GregorianCalendar cal = new GregorianCalendar(2019, 2, 17);
		CalDay calday = new CalDay(cal);
		String outputArray[] = new String[6000];
		int outputArrayTime[] = new int [6000];
		int sizeLess = 0;
		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				String tempOutputArray[] = new String[6000];
				int tempOutputArrayTime[] = new int [6000];
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);


				int startMinute = (ValuesGenerator.RandInt(random));
				int startHour = ((ValuesGenerator.RandInt(random)+ValuesGenerator.RandInt(random))+8);

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
				String output = "";
				calday.addAppt(appt);
				if (!(appt.getValid())){
					sizeLess = sizeLess + 1;
					for (int i =0; i <= iteration - sizeLess; i++) {
						output = output + outputArray[i];
					}
					assertEquals("\t --- 2/17/2019 --- \n --- -------- Appointments ------------ --- \n" + output + "\n", calday.toString());
				}
				else {
					//Construct a new Appointment object with the initial data

					String half = (appt.getStartHour() > 11) ? "pm" : "am";
					int printableHour = appt.getStartHour();
					if (printableHour > 11) {
						printableHour -= 12;
					}
					if (printableHour == 0) {
						printableHour = 12;
					}
					String represntationApp = printableHour + ":" + appt.getStartMinute() + half;
					output = "\t" + startMonth + "/" + startDay + "/" + startYear + " at " + represntationApp + " ," + title + ", " + description + "\n ";
					int check = 0;
					for (int i = 0; i < iteration - sizeLess; i++) {
						//Put the appointment in the correct order - finish this
						System.out.println("StartHour:" + startHour + " outputArrayTime[" + i + "]: " + outputArrayTime[i] + "for" + outputArray[i]);
						if (startHour < outputArrayTime[i]) {
							check = 1;
							for (int j = 0; j < i; j++) {
								tempOutputArrayTime[j] = outputArrayTime[j];
								tempOutputArray[j] = outputArray[j];
							}
							tempOutputArray[i] = output;
							tempOutputArrayTime[i] = startHour;
							for (int j = i + 1; j < (iteration + 1) - sizeLess; j++) {
								tempOutputArrayTime[j] = outputArrayTime[j - 1];
								tempOutputArray[j] = outputArray[j - 1];
							}
							for (int j = 0; j < (iteration + 1) - sizeLess; j++) {
								outputArrayTime[j] = tempOutputArrayTime[j];
								outputArray[j] = tempOutputArray[j];
							}
							break;
						}
					}
					if (check == 0) {
						outputArrayTime[iteration-sizeLess] = startHour;
						outputArray[iteration-sizeLess] = output;
					}
					output = "";
					for (int i = 0; i <= iteration-sizeLess; i++) {
						output = output + outputArray[i];
					}


					assertEquals("\t --- 2/17/2019 --- \n --- -------- Appointments ------------ --- \n" + output + "\n", calday.toString());
				}
				assertEquals((iteration+1)-sizeLess, calday.getSizeAppts());

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("CalDay elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		} catch (NullPointerException e) {


		}
		System.out.println("Done testing...");
	}
}