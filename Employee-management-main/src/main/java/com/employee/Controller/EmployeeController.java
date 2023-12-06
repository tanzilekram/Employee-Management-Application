package com.employee.Controller;

import com.employee.Entity.EmployeeBO;
import com.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    private ResponseEntity<EmployeeBO> addEmployee (@RequestBody EmployeeBO employeeBO){
         EmployeeBO savedEmployee = employeeService.addEmployee(employeeBO);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<EmployeeBO> updateEmployee (@RequestBody EmployeeBO employeeBO){
        EmployeeBO updatedEmployee = employeeService.updateEmployee(employeeBO);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        EmployeeBO deletedEmployee = employeeService.deleteEmployee(id);
        if (deletedEmployee == null) {
            return new ResponseEntity<>("Employee with ID: " + id + " is not present in the database", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Employee with ID: " + id + " has been deleted", HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    private ResponseEntity<EmployeeBO> getEmployeeById (@PathVariable Integer id){
        EmployeeBO gotEmployee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(gotEmployee,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<EmployeeBO>> getAllEmployee (){
        List<EmployeeBO> allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee,HttpStatus.OK);
    }
}
