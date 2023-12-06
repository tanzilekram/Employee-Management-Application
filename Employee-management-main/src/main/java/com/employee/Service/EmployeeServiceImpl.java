package com.employee.Service;

import com.employee.Dao.EmployeeDao;
import com.employee.Entity.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public EmployeeBO addEmployee(EmployeeBO employeeBO) {
        return employeeDao.addEmployee(employeeBO);
    }

    @Override
    public EmployeeBO updateEmployee(EmployeeBO employeeBO) {
        return employeeDao.updateEmployee(employeeBO);
    }

    @Override
    public EmployeeBO deleteEmployee(Integer id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public EmployeeBO getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<EmployeeBO> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
