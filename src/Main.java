import controller.Controller;
import entity.Department;
import entity.ExpenseReportEntity;
import sql.Operation;

import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws SQLException {

        Operation operation = new Operation();

        ArrayList<Department> departments = operation.fetchAllDepartments();
        ArrayList<ArrayList<ExpenseReportEntity>> expenses = new ArrayList<>();

        for (Department department : departments) {
            String department_id = department.getDepartment_id();
            String department_name = department.getDepartment_name();
            ArrayList<ExpenseReportEntity> expense = operation.getExpenseBy(department_id, department_name, Config.REPORT_YEAR);
            expenses.add(expense);
        }
        operation.closeConnection();

        Controller.transferToReport(Config.REPORT_PATH, expenses);

    }

}
