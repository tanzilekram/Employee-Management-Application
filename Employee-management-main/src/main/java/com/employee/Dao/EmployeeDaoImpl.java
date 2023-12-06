package com.employee.Dao;


import com.employee.Entity.EmployeeBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public EmployeeBO addEmployee(EmployeeBO employeeBO) {
        entityManager.persist(employeeBO);
        entityManager.flush();
        entityManager.clear();
        return employeeBO;
    }

    @Override
    public EmployeeBO updateEmployee(EmployeeBO employeeBO) {
        entityManager.merge(employeeBO);
        entityManager.flush();
        entityManager.clear();
        return employeeBO;
    }

    @Override
    public EmployeeBO deleteEmployee(Integer id) {
        EmployeeBO employeeBO = entityManager.find(EmployeeBO.class, id);
        entityManager.remove(employeeBO);
        return employeeBO;
    }

    @Override
    public EmployeeBO getEmployeeById(Integer id) {
        EmployeeBO employeeBO;
        return entityManager.find(EmployeeBO.class, id);
    }

    @Override
    public List<EmployeeBO> getAllEmployee() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeBO> criteriaQuery = criteriaBuilder.createQuery(EmployeeBO.class);
        Root<EmployeeBO> root = criteriaQuery.from(EmployeeBO.class);
        CriteriaQuery<EmployeeBO> all = criteriaQuery.select(root);

        TypedQuery<EmployeeBO> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }
}

