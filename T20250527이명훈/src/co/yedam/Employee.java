package co.yedam;

/*
 * 사원번호, 이름, 전화번호, 입사일자, 급여 항목을 필드로 선언하고
 * 필요한 메소드를 정의하세요.
 */
public class Employee {
	private String empNo;
	private String empName;
	private String phone;
	private String hireDate;
	private int salary;

	public Employee() {
	}

	public Employee(String empNo, String empName, String phone, String hireDate, int salary) {

		this.setEmpNo(empNo);
		this.setEmpName(empName);
		this.setHireDate(hireDate);
		this.setPhone(phone);
		this.setSalary(salary);
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return empNo + "  " + empName + "  " + phone;
	}
	public String hireDay() {
		return empNo+"\t"+empName+"\t"+hireDate;
	}
}
