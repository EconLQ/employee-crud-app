package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;
import com.liquidus.employeecrudapp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static Connection connection = DBConnection.getConnection();

    public static void main(String[] args) {
    }

    @Override
    public boolean addEmployee(Employee employee) {
        System.out.println("Start addEmployee");
        try {
            String insertStatement = "insert into employee_db.employee (name, email, phone, address) VALUES (?,?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getAddress());

            int result = preparedStatement.executeUpdate();
            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return null;
    }
}
