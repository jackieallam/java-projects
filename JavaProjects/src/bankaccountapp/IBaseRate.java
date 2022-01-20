package bankaccountapp;

public interface IBaseRate {

	// Method that returns the Base Rate (this could be an API call)
	default double getBaseRate() {
		return 2.5;
	}
}
