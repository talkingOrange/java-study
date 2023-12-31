package chapter04;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		
		System.out.println("=====방법1=====");
		
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		
		System.out.println("=====방법2=====");
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11); //12월, MONTH-1
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		System.out.println("=====방법3=====");
		
		cal.set(2000, 11, 03);
		cal.add(Calendar.DATE, 10000); //10000일 지난 날
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS= { "일", "월", "화", "수", "목", "금", "토" };
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); //0~11. +1 필요
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); //1(일)~7(토). 
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				(year) + "/" + (month + 1) + "/" + date + " " + DAYS[day-1] + "요일 " + hour + ":" + minute + ":" + second);
	}
}
