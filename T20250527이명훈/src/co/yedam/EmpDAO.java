package co.yedam;

import java.util.ArrayList;
import java.util.List;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {
	// 사원정보를 저장하는 컬렉션.
	List<Employee> storage = new ArrayList<Employee>();

	public void add(Employee emp) {
		Employee type = new Employee();
		type.setEmpNo(emp.getEmpNo());
		type.setEmpName(emp.getEmpName());
		type.setHireDate(emp.getHireDate());
		type.setPhone(emp.getPhone());
		type.setSalary(emp.getSalary());
		
		storage.add(type);
	}
	
	public List<Employee> list() {
		return storage;
	}
	
	public boolean modify(String empNo,int salary) {
		for(Employee e : storage) {
			if(e.getEmpNo().equals(empNo)) {
				e.setSalary(salary);
				return true;
			}
		}
		return false;
	}

	public boolean remove(String empNo) {
		for(Employee e: storage) {
			if(e.getEmpNo().equals(empNo)) {
				storage.remove(e);
				return true;
			}
		}
		return false;
	}
	public List<Employee> searching(String hiredate) {
	    List<Employee> result = new ArrayList<>();
	    for (Employee e : storage) {
	        if (e.getHireDate().compareTo(hiredate)>=0) {
	            result.add(e);
	        }
	    }
	    return result;
	}

}
