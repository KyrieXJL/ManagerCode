package com.xjl.bean;

/**
 * @author:xjl
 * @date:2020/5/24 21:13
 */
public class Department {
    private  Integer dept_id;
    private  String dept_leader;
    private  String dept_name;
    public Department() {

    }
    public Department(Integer deptId, String deptLeader, String deptName) {
        this.dept_id = deptId;
        this.dept_leader = deptLeader;
        this.dept_name = deptName;
    }

    public Integer getDeptId() {
        return dept_id;
    }

    public void setDeptId(Integer deptId) {
        this.dept_id = deptId;
    }

    public String getDeptLeader() {
        return dept_leader;
    }

    public void setDeptLeader(String deptLeader) {
        this.dept_leader = deptLeader;
    }

    public String getDeptName() {
        return dept_name;
    }

    public void setDeptName(String deptName) {
        this.dept_name = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + dept_id +
                ", deptLeader='" + dept_leader + '\'' +
                ", deptName='" + dept_name + '\'' +
                '}';
    }
}
