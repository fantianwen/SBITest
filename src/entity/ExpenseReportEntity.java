package entity;

public class ExpenseReportEntity extends Expense{

    private String departmentName;

    public ExpenseReportEntity(String money, String department_id, String departmentName, String month, String year) {
        super(money, department_id, month, year);
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String[] toCscRecord() {
        String[] strings = new String[5];
        strings[0] = this.getDepartment_id();
        strings[1] = this.getDepartmentName();
        strings[2] = this.getMoney();
        strings[3] = this.getYear();
        strings[4] = this.getMoney();
        return strings;
    }
}
