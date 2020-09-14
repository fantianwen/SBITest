package controller;

import com.csvreader.CsvWriter;
import entity.ExpenseReportEntity;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Controller {

    public static void transferToReport(String path, ArrayList<ArrayList<ExpenseReportEntity>> expenses){

        if(expenses == null || expenses.size()<=0){
            return;
        }

        for(ArrayList<ExpenseReportEntity> departmentExpense: expenses){

            // fetch department name for file name writing
            String departmentName = departmentExpense.get(0).getDepartmentName();
            String year = departmentExpense.get(0).getYear();

            try {
                CsvWriter csvWriter = new CsvWriter(  path + year+"/"+ departmentName+".csv",',', Charset.forName("UTF-8"));

                String[] headers = {"department id","department name", "month", "year", "expense"};
                csvWriter.writeRecord(headers);

                for (ExpenseReportEntity expenseReportEntity: departmentExpense){
                    csvWriter.writeRecord(expenseReportEntity.toCscRecord());
                }

                csvWriter.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
