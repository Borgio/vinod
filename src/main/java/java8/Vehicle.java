package java8;

public interface Vehicle {

	static String producer() {
	    return "Vinod Vehicles";
	}
	
	default String getOverview() {
	    return "ATV made by " + producer();
	}
	
}
