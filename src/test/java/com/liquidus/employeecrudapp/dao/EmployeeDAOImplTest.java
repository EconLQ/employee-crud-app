package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeDAOImplTest {
    @Test
    void addEmployeeTest() {
        Employee employee = new Employee("Mike", "mike13@gmail.com", "38099341912", "Kyiv, Maidan");
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        assertTrue(employeeDAO.addEmployee(employee));
    }
}