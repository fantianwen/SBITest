package entity;

public class Expense {

    private String money;
    private String department_id;
    private String month;
    private String year;

    public Expense(String money, String department_id, String month, String year) {
        this.money = money;
        this.department_id = department_id;
        this.month = month;
        this.year = year;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "money='" + money + '\'' +
                ", department_id='" + department_id + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
