package com.xjl.mapper;

import com.xjl.bean.Department;
import com.xjl.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmployeeMapper {
    String TABLE_NAME = "tbl_emp";
    String INSERT_FIELDS = "emp_name, emp_email, gender, department_id";
    String SELECT_FIELDS = "emp_id, " + INSERT_FIELDS;
    /**删除
     */
    @Delete({"delete from", TABLE_NAME, "where emp_id = #{empId}"})
    int deleteOneById(@Param("empId") Integer empId);

    /**更新
     */
    @Update({"update",TABLE_NAME,"set emp_name=#{employee.empName},emp_email=#{employee.empEmail},gender=#{employee.gender},department_id=#{employee.departmentId}","where emp_id=#{empId}"})
    int updateOneById(@Param("empId") Integer empId,
                      @Param("employee") Employee employee);
    /**新增
     */
    @Insert({"insert into", TABLE_NAME, "(",INSERT_FIELDS,") " +
                    "values(#{empName}, " +
                    "#{empEmail}, " +
                    "#{gender}, " +
                    "#{departmentId})"})
    int insertOne(Employee employee);

    /**查询
     */
    @Select({"select * from",TABLE_NAME,"where emp_id=#{empId}"})
    Employee selectOneById(@Param("empId") int empId);
    @Select({"select * from",TABLE_NAME,"where emp_name=#{empName}"})
    Employee selectOneByName(@Param("empName") String empName);
    //查询带有部门信息的Employee
    @Select({"select * from tbl_dept where dept_id=#{empId}"})
    Department selectWithDeptById(@Param("empId") Integer empId);

    /**
     * 分页查询
     * @param limit 返回记录最大行数
     * @param offset 返回记录行的偏移量
     * @return 如offset=10，limit=5的时候，就会从数据库第11行记录开始返回5条查询结果，即范围从(offset+1)---(offset+limit)
     */
    @Select({"select * from",TABLE_NAME,"limit #{limit} offset #{offset}"})
    List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset,
                                          @Param("limit") Integer limit);

    /**
     * 查询总记录数
     * @return
     */
    @Select({"select count(*) from", TABLE_NAME})
    int countEmps();

}
