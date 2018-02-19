package vn.viettuts.autowiring.no;

public class StudentAddress {
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [city = " + city + "]";
	}
}
