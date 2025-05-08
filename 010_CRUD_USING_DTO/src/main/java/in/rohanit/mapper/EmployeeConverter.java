package in.rohanit.mapper;

import in.rohanit.dto.EmployeeDto;
import in.rohanit.entity.Employee;

public class EmployeeConverter {

	//convert entity to dto
	public static EmployeeDto toDTO(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setDepartment(employee.getDepartment());
		return dto;
	}
	
	//convert dto to entity
	
	public static Employee toEntity(EmployeeDto employeeDto) {
		Employee emp = new Employee();
		emp.setId(employeeDto.getId());
		emp.setName(employeeDto.getName());
		emp.setDepartment(employeeDto.getDepartment());
		return emp;
	}

	
}
