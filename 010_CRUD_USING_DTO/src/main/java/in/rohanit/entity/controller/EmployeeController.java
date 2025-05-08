package in.rohanit.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rohanit.dto.EmployeeDto;
import in.rohanit.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	 @Autowired
	 private EmployeeService employeeService;

	    // Create Employee
	    @PostMapping
	    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDTO) {
	        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
	    }

	    // Get Employee by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
	        EmployeeDto employeeDTO = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employeeDTO);
	    }

	    // Get All Employees
	    @GetMapping
	    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
	        List<EmployeeDto> employees = employeeService.getAllEmployees();
	        return ResponseEntity.ok(employees);
	    }

	    // Update Employee
	    @PutMapping("/{id}")
	    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
	    		@RequestBody EmployeeDto employeeDTO) {
	        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    // Delete Employee
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }
}
