import entity.Department;
import entity.Expense;
import sql.Operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {

    public static String mYEAR = "2019";

    public static void main(String[] args) throws SQLException {

        Operation operation = new Operation();

        ArrayList<Department> departments = operation.fetchAllDepartments();

        for (Department department : departments) {
            String department_id = department.getDepartment_id();
            ArrayList<Expense> expense = operation.getExpenseBy(department_id, mYEAR);


        }
    }

}
