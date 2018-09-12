package simpletimeclient;

import java.time.*;
import java.util.*;

public interface TimeClient {
	static ZoneId getZoneId(String zoneString) {
		try {
			return ZoneId.of(zoneString);
		} catch (DateTimeException e) {
			System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
			return ZoneId.systemDefault();
		}
	}

	void setTime(int hour, int month, int year);

	void setDate(int day, int month, int year);

	void setDateAndTime(int day, int month, int year, int hour, int minute, int second);

	LocalDateTime getLocalDateTime();

	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
	}
}
