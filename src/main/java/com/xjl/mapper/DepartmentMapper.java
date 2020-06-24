package com.xjl.mapper;

import com.xjl.bean.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author:xjl
 * @date:2020/5/24 21:44
 */
public interface DepartmentMapper {
    String TABLE_NAME="tbl_dept";
    String INSERT_FIELDS="dept_name,dept_leader";
    String SELECT_FIELDS="dept_id as 'deptId',dept_name as 'deptName' dept_leader as 'deptLeader'";
    /**
     * 删除
     * */
    @Delete({"delete from",TABLE_NAME,"where dept_id=#{deptId}"})
    int deleteDeptById(@Param("deptId") Integer deptId);
    /**
     * 更新
     * */

    int updateDeptById(@Param("deptId") Integer deptId, @Param("department")Department department);

    /**
     * 添加
     * */
    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values(#{department.deptName},#{department.deptLeader})" })
    int insertDept(@Param("department") Department department);

    /**
     *查询
     * */

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where dept_id=#{deptId}"})
    Department selectOneById(@Param("deptId") Integer deptId);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where dept_leader=#{deptLeader}"})
    Department selectOneByLeader(@Param("deptLeader") String deptLeader);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"Where dept_name=#{deptName}"})
   Department selectOneByName(@Param("deptName") String deptName);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME})
    List<Department> selectDeptList();

    List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset,@Param("limit") Integer limit);

    @Select({"select count(dept_id) from",TABLE_NAME,"where deptLeader=#{deptLeader} or deptName=#{deptName}"})
    int checkDeptsExitsByNameAndleader(@Param("deptLeader") String deptLeader,@Param("deptName") String deptName);

    @Select({"select count(*) from",TABLE_NAME})
    int countDepts();}
