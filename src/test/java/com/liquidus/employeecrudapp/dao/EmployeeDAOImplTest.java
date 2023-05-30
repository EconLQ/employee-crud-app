package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeDAOImplTest {
    @Test
    void addEmployeeTest() {
        Employee employee = new Employee("Mike", "mike13@gmail.com", "38099341912", "Kyiv, Maidan");
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        assertTrue(employeeDAO.addEmployee(employee));
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(10, "Thomas Dante", "tomFX@gmail.com", "38099341912", "Kyiv, Maidan");
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        assertTrue(employeeDAO.updateEmployee(employee));
    }

    @Test
    void deleteEmployee() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        assertTrue(employeeDAO.deleteEmployee(13)); // employee.getId() = 13
    }

    @Test
    void getAllEmployees() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> list = employeeDAO.getAllEmployees();
        System.out.println(list);
    }

    @Test
    void getEmployee() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.getEmployee(2);
        System.out.println(employee);
    }
}