package com.example.jpa.model.Controller;

import com.example.jpa.model.Model.Employee;
import com.example.jpa.model.Model.EmployeeProfile;
import com.example.jpa.model.Service.EmployeeProfileService;
import com.example.jpa.model.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeProfileService employeeProfileService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,EmployeeProfileService employeeProfileService) {
        this.employeeService = employeeService;
        this.employeeProfileService = employeeProfileService;
    }

    @GetMapping("/allProfiles")
    public List<EmployeeProfile> getEmployeeProfile(){
        return employeeProfileService.getEmployeeProfile();
    }

    @GetMapping("/getJuniorPositions/{position}")
    public List<EmployeeProfile> getJuniorPositions(@PathVariable String position){
        return employeeProfileService.getJuniorPositions(position);
    }
    @GetMapping("/getDeveloperDepartments/{department}")
    public List<EmployeeProfile> getDeveloperDepartment(@PathVariable String department){
        return employeeProfileService.getDeveloperDepartment(department);
    }

    @PostMapping("/registerProfile")
    public void registerNewEmployeeProfile(@RequestBody Employee employee,
                                           String position,String department) {
        employeeProfileService.addNewEmployeeProfile(employee,position,department);
    }

    @DeleteMapping(path = "{employeeProfileId}")
    public void deleteEmployeeProfile(@PathVariable("employeeProfileId") Long employeeProfileId) {
        employeeProfileService.deleteEmployeeProfile(employeeProfileId);
    }

    @PutMapping(path = "{employeeProfileId}")
    public void updateEmployeeProfilePosition(
            @PathVariable("employeeProfileId") Long employeeProfileId,
            @RequestParam(required = false) String position){
        employeeProfileService.updateEmployeeProfilePosition(employeeProfileId,position);
    }

    @GetMapping("/allEmployees")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @PostMapping("/register")
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployeeEmail(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String newEmail) {
        employeeService.updateEmployeeEmail(employeeId,newEmail);
    }
}
