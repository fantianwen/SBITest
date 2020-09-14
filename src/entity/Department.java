package entity;

public class Department {

    // for int only ranges from -2147483648 to 2147483647
    private String department_id;
    private String department_name;

    public Department(String department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id='" + department_id + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}