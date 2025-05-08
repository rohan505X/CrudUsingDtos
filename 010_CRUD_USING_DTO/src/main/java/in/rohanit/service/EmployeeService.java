package in.rohanit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rohanit.dto.EmployeeDto;
import in.rohanit.entity.Employee;
import in.rohanit.entity.repository.EmployeeRepository;
import in.rohanit.mapper.EmployeeConverter;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	//create employee
	public EmployeeDto createEmployee(EmployeeDto employeeDto){
		Employee employee = EmployeeConverter.toEntity(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeConverter.toDTO(savedEmployee);
		
	}
	
	//get employee by id
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));
	    return EmployeeConverter.toDTO(employee);
	}
	
	//get all employees
	public List<EmployeeDto> getAllEmployees(){
		return employeeRepository.findAll()
				.stream()
				.map(EmployeeConverter::toDTO)
				.collect(Collectors.toList());
	}

	//update Employee
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(id).
		orElseThrow(() -> new RuntimeException("Employee Not found"));
	  employee.setName(employeeDto.getName());
	  employee.setDepartment(employeeDto.getDepartment());
	  Employee updatedEmployee = employeeRepository.save(employee);
	  return EmployeeConverter.toDTO(updatedEmployee);
	}
	
	//delete Employee
	public void deleteEmployee(Long id) {
		if(!employeeRepository.existsById(id)) {
			throw new RuntimeException("Employee not found");
		}
		else {
			employeeRepository.deleteById(id);
		}
	}
}
