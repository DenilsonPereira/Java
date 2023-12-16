package course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date x1 = new Date();
		
		Date y1 = sdf1.parse("25/12/2023");
		Date y2 = sdf2.parse("18/08/1998 15:02:59");
		Date y3 = Date.from(Instant.parse("2023-06-25T14:42:15Z"));

		System.out.println("----------------------------");
		System.out.println("x1: " +sdf2.format(x1));
		System.out.println("y1: " +sdf2.format(y1));
		System.out.println("y2: " +sdf2.format(y2));
		System.out.println("y3: " +sdf2.format(y3));
		System.out.println("----------------------------");
		System.out.println("x1: " +sdf3.format(x1));
		System.out.println("y1: " +sdf3.format(y1));
		System.out.println("y2: " +sdf3.format(y2));
		System.out.println("y3: " +sdf3.format(y3));
	}

}
