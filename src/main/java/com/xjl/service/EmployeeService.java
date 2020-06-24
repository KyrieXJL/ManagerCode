package com.xjl.service;

import com.xjl.bean.Employee;
import com.xjl.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:xjl
 * @date:2020/6/2 17:39
 */
@Service
public class EmployeeService {
    EmployeeMapper employeeMapper;
    public int getEmpCount(){
        return employeeMapper.countEmps();
    }
    public List<Employee> getEmpList(Integer offser, Integer limit){
        return employeeMapper.selectByLimitAndOffset(offser, limit);
    }
    public Employee getEmpById(Integer empId){
        return employeeMapper.selectOneById(empId);
    }
    public Employee getEmpByName(String empName){return employeeMapper.selectOneByName(empName);};
    public int updateEmpById(Integer empId, Employee employee){return employeeMapper.updateOneById(empId, employee);}
    public int deleteEmpById(Integer empId){
        return employeeMapper.deleteOneById(empId);
    }
    public int addEmp(Employee employee){
        return employeeMapper.insertOne(employee);
    }
}
