package com.example.jpa.model.Service;


import com.example.jpa.model.Model.Employee;
import com.example.jpa.model.Model.EmployeeProfile;
import com.example.jpa.model.Repository.EmployeeProfileRepository;
import com.example.jpa.model.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeProfileService {
    @Autowired

    private EmployeeProfileRepository employeeProfileRepository;

    @Autowired
    private EmployeeRepository employeeRepository;



    @Autowired
    public EmployeeProfileService(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }


    public List<EmployeeProfile> getEmployeeProfile() {
        return employeeProfileRepository.findAll();
    }

    public void addNewEmployeeProfile(Employee employee,String position,String department ){
        Optional<EmployeeProfile> employeeProfileOptional = employeeProfileRepository.findById(employee.getId());
        if (employeeProfileOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Saved employee");
        }
        EmployeeProfile employeeProfile=new EmployeeProfile(department,position,employee);
        employeeProfileRepository.save(employeeProfile);
    }

    public void deleteEmployeeProfile(Long employeeProfileId) {
        boolean exists = employeeProfileRepository.existsById(employeeProfileId);
        if (!exists) {
            throw new IllegalStateException("employee Profile with Id " + employeeProfileId + " does not exist");
        }
        employeeProfileRepository.deleteById(employeeProfileId);
    }

    public void updateEmployeeProfilePosition(Long employeeProfileId,String position) {
        EmployeeProfile employeeProfile = employeeProfileRepository.findById(employeeProfileId).orElseThrow(() ->
                new IllegalStateException("employeeProfile with Id " + employeeProfileId + " does not exist"));
        if(position != null && position.length()>0 && Objects.equals(employeeProfile.getPosition(),position)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Please check position Name");
        }
        employeeProfile.setPosition(position);
        employeeProfileRepository.save(employeeProfile);
    }

    public List<EmployeeProfile> getJuniorPositions(String position) {
        return employeeProfileRepository.findEmployeeProfileByPosition(position);
    }

    public List<EmployeeProfile> getDeveloperDepartment(String department) {
        return employeeProfileRepository.findEmployeeProfilesByDepartment(department);
    }
}
