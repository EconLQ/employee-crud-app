package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;

import java.util.List;

public interface EmployeeDAO {
    public boolean addEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(int employeeId);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int employeeId);
}
