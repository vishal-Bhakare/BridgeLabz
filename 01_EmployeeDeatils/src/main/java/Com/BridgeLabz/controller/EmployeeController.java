package Com.BridgeLabz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Com.BridgeLabz.entity.Employee;
import Com.BridgeLabz.service.EmployeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeService service;

	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmployee(@RequestBody @Valid Employee emp) {

		service.saveEmp(emp);

		return new ResponseEntity<String>("Employee Saved SuccessFully", HttpStatus.CREATED);

	}

	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

		Employee employee = service.getEmployee(id);

		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping("getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		return new ResponseEntity<List<Employee>>(service.getAllEmp(), HttpStatus.OK);
	}

	@PutMapping("updateEmp/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody @Valid Employee emp, @PathVariable Integer id) {

		return new ResponseEntity<String>(service.updateEmployee(emp, id), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {

		return new ResponseEntity<String>(service.deleteEmployee(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllEmp")
	public ResponseEntity<String> deleteAllEmployee() {

		return new ResponseEntity<String>(service.deleteAllEmployee(), HttpStatus.OK);
	}

}
