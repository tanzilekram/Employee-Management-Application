package com.employee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employeeDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String name;
    private String address;
    private String salary;
    private String department;
    private String phoneNumber;
    private String email;
}
