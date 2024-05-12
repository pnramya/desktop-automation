package generic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	LocalDateTime Date;
	DateTimeFormatter dtf;

	// Fetch the current date
	public String currentdate() {
		dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Date = LocalDateTime.now();
		return dtf.format(Date);
	}

	// When we use default date and time we need this method
//	public String customDate() {
//		dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		Date = LocalDateTime.of(2022,11, 24, 0, 0);
//		return dtf.format(Date);
//	}

	public String MinusDays(int days) {
		LocalDateTime MinusDays = Date.minusDays(days);
		return dtf.format(MinusDays);
	}

	public String minusMonths(int days) {
		LocalDateTime minusMonths = Date.minusMonths(days);
		return dtf.format(minusMonths);
	}

	public String daysplus(int days) {
		LocalDateTime daysplus = Date.plusDays(days);
		return dtf.format(daysplus);
	}

	public String monthplus(int days) {
		LocalDateTime monthplus = Date.plusMonths(days);
		return dtf.format(monthplus);
	}

}
