package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeId);
    List<Employee> getAllEmployees();
    Employee getEmployee(int employeeId);
}
