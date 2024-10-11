package Com.BridgeLabz.service;
import java.util.List;

import Com.BridgeLabz.entity.Employee;

public interface EmployeService {
	
	public void saveEmp(Employee emp);
	public Employee getEmployee(Integer id);
	public List<Employee> getAllEmp();
	public String updateEmployee(Employee emp,Integer id);
	public String deleteEmployee(Integer id);
	public String deleteAllEmployee();

}
