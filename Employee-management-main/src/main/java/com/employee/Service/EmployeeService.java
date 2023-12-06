package com.employee.Service;

import com.employee.Entity.EmployeeBO;

import java.util.List;

public interface EmployeeService {

    EmployeeBO addEmployee(EmployeeBO employeeBO);
    EmployeeBO updateEmployee(EmployeeBO employeeBO);
    EmployeeBO deleteEmployee (Integer id);
    EmployeeBO getEmployeeById (Integer id);
    List<EmployeeBO> getAllEmployee ();
}
