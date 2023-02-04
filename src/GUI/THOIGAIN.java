package GUI;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import connect_DB.connectDB;

public class THOIGAIN {

	private static long a;
	private static long differenc;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		// String time1 = "12:00:00";
	      //  String time2 = "13:00:00";
	        //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	       // Date date1 = format.parse(time1);
	       // Date date2 = format.parse(time2);
	        //long difference = date2.getTime() - date1.getTime();
	        //System.out.println(difference/1000/60);
	        
	     /*   SimpleDateFormat df  = new SimpleDateFormat("dd-MM-yyyy");
			LocalDateTime ate  = java.time.LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			System.out.println("date : "+dtf.format(ate));*/
			
		
	//	LocalDateTime ngaytaoDon = LocalDateTime.now();
//		Timestamp ngaytao = Timestamp.valueOf(ngaytaoDon);
	//	System.out.println(ngaytao);
		//String ngay = "14:00:00";
	//	String gio = "13:00:00";
	//	long a = 
		//SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		//Date time = format.parse(gio);
		
	//	System.out.println(time);
		// differenc = time.getTime();
	//	System.out.println(differenc/1000/60);

        String dateStart = "21:33:00";
        LocalTime a = LocalTime.of(21, 30, 0);
        LocalDate b = LocalDate.of(2021, 11, 03);
        String dateStop = "10:34:59";
        LocalDateTime ngaytaoDon = LocalDateTime.now();
        LocalDateTime ngay = LocalDateTime.of(b,a);
		Timestamp d1 = null;
		Date d2 = null;
        // Custom date format
       
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

      //  Timestamp d1 = null;

     

        d1 =  Timestamp.valueOf(ngaytaoDon);

		d2 = format.parse(dateStart);

        // Get msec from each, and subtract.

     /*   long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000;

        long diffMinutes = diff / (60 * 1000);

        long diffHours = diff / (60 * 60 * 1000);

        System.out.println("Số giây : " + diffSeconds + " seconds.");

        System.out.println("Số phút: " + diffMinutes + " minutes.");

        System.out.println("Số giờ: " + diffHours + " hours.");
        
        System.out.println("Số giờ: " + d2.getHours() + " hours.");
        System.out.println("Số giờ: " + d1.getHours() + " hours.");
        long di = d2.getHours() - d2.getHours();
        System.out.println("Số giờ: " + di + " hours.");*/
        Date date = new Date(d1.getTime());
        System.out.println(date);
        long diff = date.getTime() - d1.getTime();

        long diffSeconds = diff / 1000;

        long diffMinutes = diff / (60 * 1000);

        long diffHours = diff / (60 * 60 * 1000);

        System.out.println("Số giây : " + diffSeconds + " seconds.");

        System.out.println("Số phút: " + diffMinutes + " minutes.");

        System.out.println("Số giờ: " + diffHours + " hours.");
        
        System.out.println("Số giờ: " + date.getMinutes() + " hours.");
        System.out.println("Số giờ: " + d2.getMinutes() + " hours.");
    //    long di = date.getHours() - d2.getHours();
        long di = date.getMinutes() - d2.getMinutes();
        System.out.println("Số giờ: " + di + " hours.");
    }
				
			
	
}
