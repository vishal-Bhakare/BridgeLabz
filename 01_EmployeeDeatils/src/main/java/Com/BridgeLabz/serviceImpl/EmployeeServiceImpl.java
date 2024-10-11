package Com.BridgeLabz.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.BridgeLabz.entity.Employee;
import Com.BridgeLabz.repository.EmployeeRepository;
import Com.BridgeLabz.service.EmployeService;

@Service
public class EmployeeServiceImpl implements EmployeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void saveEmp(Employee emp) {

		empRepo.save(emp);

	}

	@Override
	public Employee getEmployee(Integer id) {

		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {

		return empRepo.findAll();
	}

	@Override
	public String updateEmployee(Employee emp, Integer id) {

		Optional<Employee> empl = empRepo.findById(id);

		if (empl.isPresent()) {
			Employee employee = empl.get();

			employee.setName(emp.getName());
			employee.setEmail(emp.getEmail());
			employee.setMobileNo(emp.getMobileNo());

			empRepo.save(employee);

		} else {

			return "Invalid Id";
		}

		return "Employee Updated SuccessFully";
	}

	@Override
	public String deleteEmployee(Integer id) {

		empRepo.deleteById(id);

		return "Employee Delete SuccessFully";
	}

	@Override
	public String deleteAllEmployee() {

		empRepo.deleteAll();

		return "Employee All Delete SuccessFully";
	}

}
