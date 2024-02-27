package lab2;

public class History {
	String name;
	String date;
	String description;
	public History(String theName, String theDate, String theDescription) {
		name = theName;
		date = theDate;
		description = theDescription;
	}
	public History() {
		
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
}
