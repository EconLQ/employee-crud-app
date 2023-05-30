package com.liquidus.employeecrudapp.controller;

import com.liquidus.employeecrudapp.beans.Employee;
import com.liquidus.employeecrudapp.dao.EmployeeDAO;
import com.liquidus.employeecrudapp.dao.EmployeeDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = "/")
public class EmployeeController extends HttpServlet {
    EmployeeDAO employeeDAO = null;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Employee Controller, doPost method started");

        String action = request.getServletPath();
        System.out.println("doPost, action ==> " + action);

        switch (action) {
            case "/add":
                addNewEmployee(request, response);
                break;
            case "/update":
                updateEmployee(request, response);
                break;
            case "/delete":
                deleteEmployee(request, response);
                break;
            case "/get":
                getEmployee(request, response);
                break;
            default:
                getAllEmployees(request, response);
                break;
        }
    }

    private void getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Started getAllEmployees");
        List<Employee> employees = employeeDAO.getAllEmployees();

        System.out.println("getAllEmployees, employees size ==> " + employees.size());


        RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getEmployee(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Started getEmployee");
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.getEmployee(id);

        System.out.println("getEmployee, employee details ==> " + employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Started deleteEmployee");

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("deleteEmployee, Employee id is ==> " + id);

        boolean result = employeeDAO.deleteEmployee(id);
        System.out.println("deleteEmployee, result is ==> " + result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Started updateEmployee");

        Employee employee = getEmployeeAttrsFromRequest(request);
        System.out.println("updateEmployee, Employee details ==> " + employee);

        boolean result = employeeDAO.updateEmployee(employee);
        System.out.println("updateEmployee, result is ==> " + result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee getEmployeeAttrsFromRequest(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Employee employee = new Employee(id, name, email, phone, address);
        return employee;
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Started addNewEmployee");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Employee employee = new Employee(name, email, phone, address);
        System.out.println("addNewEmployee, Employee details ==> " + employee);

        boolean result = employeeDAO.addEmployee(employee);
        System.out.println("addNewEmployee, result is ==> " + result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/employeesView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
