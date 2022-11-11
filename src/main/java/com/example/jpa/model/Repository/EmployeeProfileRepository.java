package com.example.jpa.model.Repository;

import com.example.jpa.model.Model.Employee;
import com.example.jpa.model.Model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile,Long>{

  List<EmployeeProfile> findEmployeeProfileByPosition(String position);
  Optional<EmployeeProfile> findEmployeeProfileByEmployeeId(Long id);

  List<EmployeeProfile> findEmployeeProfilesByDepartment(String position);
}
