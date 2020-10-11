package com.xjl.bean;

/**
 * @author:xjl
 * @date:2020/5/24 21:15
 */
public class Employee {
    private Integer emp_id;
    private String emp_name;
    private String emp_email;
    private String gender;
    private Integer department_id;
    private Department department;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail, String gender, Integer departmentId) {
        this.emp_id = empId;
        this.emp_name = empName;
        this.emp_email = empEmail;
        this.gender = gender;
        this.department_id = departmentId;
    }


    public Integer getEmpId() {
        return emp_id;
    }

    public void setEmpId(Integer empId) {
        this.emp_id = empId;
    }

    public String getEmpName() {
        return emp_name;
    }

    public void setEmpName(String empName) {
        this.emp_name = empName;
    }

    public String getEmpEmail() {
        return emp_email;
    }

    public void setEmpEmail(String empEmail) {
        this.emp_email = empEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(Integer departmentId) {
        this.department_id = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", gender='" + gender + '\'' +
                ", department_id=" + department_id +
                ", department=" + department +
                '}';
    }
}
