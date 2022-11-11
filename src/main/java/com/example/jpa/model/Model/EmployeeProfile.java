package com.example.jpa.model.Model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Table(name = "employee_profile")
public class EmployeeProfile extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max=65)
    private String department;

    @NotNull
    @Size(max=65)
    private String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;



    public EmployeeProfile() {
    }

    public EmployeeProfile(String department, String position,Employee employee) {
        this.employee=employee;
        this.department = department;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return "EmployeeProfile{" +
                "department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", employee=" + employee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeProfile that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDepartment(), that.getDepartment()) && Objects.equals(getPosition(), that.getPosition()) && Objects.equals(getEmployee(), that.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartment(), getPosition(), getEmployee());
    }
}
