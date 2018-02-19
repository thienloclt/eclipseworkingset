package vn.viettuts.autowiring.constructor;

public class Employee1 {
	private EmployeeAddress1 address;

	public Employee1(EmployeeAddress1 address1) {
		System.out.println("running...");
		this.address = address1;
	}

	public EmployeeAddress1 getAddress() {
		return address;
	}

	public void setAddress(EmployeeAddress1 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
}
