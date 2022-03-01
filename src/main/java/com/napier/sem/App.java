package com.napier.sem;

import com.napier.sem.Models.City;
import com.napier.sem.Reports.CountryReport;

import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * entry point of the program
     * @param args input arguments
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        CountryReport countryReport = new CountryReport(a.con);

        System.out.println(a.getCity(1).district);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "world");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Return an employee
     * @param ID
     * @return City
     */
    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, " +
                            "name, " +
                            "countrycode," +
                            "district," +
                            "population "
                            + "FROM city "
                            + "WHERE id = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            City city = new City(rset);
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Prints a list of employees.
     * @param employees The list of employees to print.
     */
//    public void printSalaries(ArrayList<Employee> employees)
//    {
//        // Print header
//        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
//        // Loop over all employees in the list
//        for (Employee emp : employees)
//        {
//            String emp_string =
//                    String.format("%-10s %-15s %-20s %-8s",
//                            emp.emp_no, emp.first_name, emp.last_name, emp.salary);
//            System.out.println(emp_string);
//        }
//    }

    /**
     * Prints employee information
     * @param emp employee to display
     */
//    public void displayEmployee(Employee emp)
//    {
//        if (emp != null)
//        {
//            System.out.println(
//                    emp.emp_no + " "
//                            + emp.first_name + " "
//                            + emp.last_name + "\n"
//                            + emp.title + "\n"
//                            + "Salary:" + emp.salary + "\n"
//                            + emp.dept_name + "\n"
//                            + "Manager: " + emp.manager + "\n");
//        }
//    }
    /**
     * Gets all the current employees and salaries.
     * @return A list of all employees and salaries, or null if there is an error.
     */
//    public ArrayList<Employee> getAllSalaries()
//    {
//        try
//        {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            // Create string for SQL statement
//            String strSelect =
//                    "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
//                            + "FROM employees, salaries "
//                            + "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' "
//                            + "ORDER BY employees.emp_no ASC";
//            // Execute SQL statement
//            ResultSet rset = stmt.executeQuery(strSelect);
//            // Extract employee information
//            ArrayList<Employee> employees = new ArrayList<Employee>();
//            while (rset.next())
//            {
//                Employee emp = new Employee();
//                emp.emp_no = rset.getInt("employees.emp_no");
//                emp.first_name = rset.getString("employees.first_name");
//                emp.last_name = rset.getString("employees.last_name");
//                emp.salary = rset.getInt("salaries.salary");
//                employees.add(emp);
//            }
//            return employees;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get salary details");
//            return null;
//        }
//    }

    /**
     * Gets all the current employees and salaries ordered by title.
     * @return A list of all employees and salaries that have the title, or null if there is an error.
     */
//    public ArrayList<Employee> getSalaryByRole(String role)
//    {
//        try
//        {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            // Create string for SQL statement
//            String strSelect = "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
//                    + "FROM employees, salaries, titles "
//                    + "WHERE employees.emp_no = salaries.emp_no "
//                    + "AND employees.emp_no = titles.emp_no "
//                    + "AND salaries.to_date = '9999-01-01' "
//                    + "AND titles.to_date = '9999-01-01' "
//                    + "AND titles.title = '" + role + "'"
//                    + " ORDER BY employees.emp_no ASC";
//
//            // Execute SQL statement
//            ResultSet rset = stmt.executeQuery(strSelect);
//            // Extract employee information
//            ArrayList<Employee> employees = new ArrayList<Employee>();
//            while (rset.next())
//            {
//                Employee emp = new Employee();
//                emp.emp_no = rset.getInt("employees.emp_no");
//                emp.first_name = rset.getString("employees.first_name");
//                emp.last_name = rset.getString("employees.last_name");
//                emp.salary = rset.getInt("salaries.salary");
//                employees.add(emp);
//            }
//            return employees;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get salary details");
//            return null;
//        }
//    }


}