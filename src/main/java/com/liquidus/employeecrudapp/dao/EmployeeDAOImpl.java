package com.liquidus.employeecrudapp.dao;

import com.liquidus.employeecrudapp.beans.Employee;
import com.liquidus.employeecrudapp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static Connection connection = DBConnection.getConnection();

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

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        System.out.println("Start updateEmployee");
        try {
            String updateStatement = "update employee_db.employee set name=?, email=?, phone=?, address=? where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setInt(5, employee.getId());

            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        System.out.println("Start deleteEmployee");
        try {
            String deleteStatement = "delete from employee_db.employee where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
            preparedStatement.setInt(1, employeeId);
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("Start Select All Employees");
        try {
            String selectStatement = "select * from employee_db.employee;";
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

            ResultSet result = preparedStatement.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while (result.next()) {
                Employee employee = new Employee();

                employee.setId(result.getInt("id"));
                employee.setName(result.getString("name"));
                employee.setEmail(result.getString("email"));
                employee.setPhone(result.getString("phone"));
                employee.setAddress(result.getString("address"));

                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee getEmployee(int employeeId) {
        System.out.println("Start getEmployee");
        try {
            String getEmployeeStatement = "select * from employee_db.employee where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(getEmployeeStatement);
            preparedStatement.setInt(1, employeeId);

            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee();

            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setAddress(resultSet.getString("address"));
            }
            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
