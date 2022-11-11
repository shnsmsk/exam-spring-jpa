package com.example.jpa.model.Service;

import com.example.jpa.model.Model.Employee;
import com.example.jpa.model.Model.EmployeeProfile;
import com.example.jpa.model.Repository.EmployeeProfileRepository;
import com.example.jpa.model.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeProfileRepository employeeProfileRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }


    public void addNewEmployee(Employee employee) {
        //I only checked emails uniqueness.
        Optional<Employee> employeeOptinal = employeeRepository.findByEmail(employee.getEmail());
        if (employeeOptinal.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with Id " + employeeId + " does not exist");
        }
        Optional<EmployeeProfile> optional = employeeProfileRepository.findEmployeeProfileByEmployeeId(employeeId);
        EmployeeProfile employeeProfile= optional.get();
        boolean existProfile=employeeProfileRepository.existsById(employeeProfile.getId());
        if(existProfile){
            throw new IllegalStateException("delete employee profile first...");
        }
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployeeEmail(Long employeeId,String email) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new IllegalStateException("employee with Id " + employeeId + " does not exist"));
        if (email!=null && email.length()>0 && Objects.equals(employee.getEmail(),email)){
            Optional<Employee>employeeOptional=employeeRepository.findByEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            employee.setEmail(email);
        }
        employeeRepository.save(employee);
    }
}
