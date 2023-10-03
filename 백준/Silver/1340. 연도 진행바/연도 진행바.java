import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String month = st.nextToken();
		String sDay = st.nextToken();
		int day = Integer.parseInt(sDay.split(",")[0]);
		
		int year = Integer.parseInt(st.nextToken());
		String sTime = st.nextToken();
		int hour = 60*Integer.parseInt(sTime.split(":")[0]);
		int min = Integer.parseInt(sTime.split(":")[1]);
		
		boolean yearCheck = false;
		if(year%400==0 || (year%4==0 && year%100 !=0))
			yearCheck = true;
		
		int mon = 0;
		switch(month){
		case "January":
			mon = 1;
			break;
		case "February":
			mon = 2;
			break;
		case "March":
			mon = 3;
			break;
		case "April":
			mon = 4;
			break;
		case "May":
			mon = 5;
			break;
		case "June":
			mon = 6;
			break;
		case "July":
			mon = 7;
			break;
		case "August":
			mon = 8;
			break;
		case "September":
			mon = 9;
			break;
		case "October":
			mon = 10;
			break;
		case "November":
			mon = 11;
			break;
		case "December":
			mon = 12;
			break;
		}
		
		int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int dayCount = 0;
		for(int i=1;i<mon;i++) {
			if(yearCheck && i==2) {
				dayCount += 29;
				continue;
			}
			dayCount += days[i];
		}
		dayCount += day;
		
		int time = hour+min;
		
		int timeToHour = 60*24*(dayCount-1)+time;
		
		int totalYear = 0;
		if(yearCheck)
			totalYear = 366*60*24;
		else
			totalYear = 365*60*24;
		
		System.out.println((double)((double)timeToHour*100 / (double) totalYear));
	}
	
}
