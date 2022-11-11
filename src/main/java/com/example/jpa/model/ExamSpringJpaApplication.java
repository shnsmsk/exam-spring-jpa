package com.example.jpa.model;

import com.example.jpa.model.Model.Employee;
import com.example.jpa.model.Model.EmployeeProfile;
import com.example.jpa.model.Repository.EmployeeProfileRepository;
import com.example.jpa.model.Repository.EmployeeRepository;
import com.example.jpa.model.Service.EmployeeProfileService;
import com.example.jpa.model.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class ExamSpringJpaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeProfileRepository employeeProfileRepository;
	@Autowired
	private EmployeeProfileService employeeProfileService;
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(ExamSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		/*EmployeeProfile employeeProfile=new EmployeeProfile("dev","jun");
		Employee employee =new Employee();
		employee.setEmail("meh@gmail.com");
		employee.setFirstName("me");
		employee.setLastName("oz");
		//employee.setEmployeeProfile(employeeProfile);
		employeeRepository.save(employee);

First Run ------>

		Employee employee =new Employee();
		employee.setEmail("meh@gmail.com");
		employee.setFirstName("me");
		employee.setLastName("oz");
		employeeRepository.save(employee);
		EmployeeProfile employeeProfile=new EmployeeProfile("dev","jun");
		employeeProfile.setEmployee(employee);
		employeeProfileRepository.save(employeeProfile);

Second Run --------->

		// I have created an employee with Id = 2L via Postman , now giving that object to employeeProfile.
		//Employee can saved via postman but I couldnt save the employeeProfile via Postman because
		//I could not create the body of the employee profile via Postman.
		Employee employee = (employeeRepository.findById(2L)).get();
		EmployeeProfile employeeProfile=new EmployeeProfile("dev","jun");
		employeeProfile.setEmployee(employee);
		employeeProfileRepository.save(employeeProfile);

		Employee employee = (employeeRepository.findById(8L)).get();
		EmployeeProfile employeeProfile=new EmployeeProfile("dev","jun");
		employeeProfile.setEmployee(employee);
		employeeProfileRepository.save(employeeProfile);

		 */
		//EmployeeProfileService employeeProfileService=new EmployeeProfileService(employeeProfileRepository);
		//employeeProfileService.deleteEmployeeProfile(8L);

		employeeProfileService.updateEmployeeProfilePosition(4L,"jun");






	}
}
