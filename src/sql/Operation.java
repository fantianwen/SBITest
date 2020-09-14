package sql;

import entity.Department;
import entity.Expense;

import java.sql.*;
import java.util.ArrayList;

public class Operation {

    // tables
    public enum Table{

        DEPARTMENTS("departments"),
        EXPENSES("expenses");

        private String name;

        Table(String name){
            this.name = name;
        }
    }

    private Connection mDataBaseConnection = null;

    private void dataBaseConnection() {
        if(this.mDataBaseConnection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                this.mDataBaseConnection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/Departments",
                                "sbi", "bit");
                this.mDataBaseConnection.setAutoCommit(false);
                System.out.println("Opened database successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(){
        if(this.mDataBaseConnection!=null){
            try {
                this.mDataBaseConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // get all the departments information in the table "departments"
    public ArrayList<Department> fetchAllDepartments() {

        if(mDataBaseConnection==null) {
            dataBaseConnection();
        }

        Statement statement;

        ArrayList<Department> departments = new ArrayList<>();

        try {
            statement = mDataBaseConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s;", Table.DEPARTMENTS.name));

            while(resultSet.next()){
                String department_id = resultSet.getString("department_id");
                String department_name = resultSet.getString("department_name");

                departments.add(new Department(department_id,department_name));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;

    }

    // get all the information of expense by department Id and the year
    public ArrayList<Expense> getExpenseBy(String departmentId, String year){

        if(mDataBaseConnection == null){
           dataBaseConnection();
        }

        Statement statement;

        ArrayList<Expense> expenses = new ArrayList<>();

        try {
            statement = mDataBaseConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM %s WHERE department_id=%s AND year=%s;", Table.EXPENSES.name, departmentId, year));
            while (resultSet.next()){
                String money = resultSet.getString("expense");
                String month = resultSet.getString("month");

                expenses.add(new Expense(money,departmentId,month,year));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return expenses;
    }


}
