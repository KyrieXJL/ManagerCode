package com.xjl.mapper;
import com.xjl.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {
    String TABLE_NAME = "tbl_dept";
    String INSERT_FIELDS = "dept_name, dept_leader";
    String SELECT_FIELDS = "dept_id as 'deptId', " +
            "dept_name as 'deptName', " +
            "dept_leader as 'deptLeader'";


    /**删除
     */
    @Delete({"delete from", TABLE_NAME, "where dept_id=#{deptId}"})
    int deleteDeptById(@Param("deptId") Integer deptId);

    /**更新
     */
    @Update({"update",TABLE_NAME,"set dept_id=#{deptId}, dept_leader=#{department.deptLeader},dept_name=#{department.deptName}","where dept_id=#{deptId}"})
    int updateDeptById(@Param("deptId") Integer deptId,
                       @Param("department") Department department);

    /**新增
     */
    @Insert({"insert into",TABLE_NAME, "(", INSERT_FIELDS ,") " +
            "values(#{department.deptName}, #{department.deptLeader})" })
    int insertDept(@Param("department") Department department);

    /**查询
     */
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where dept_id=#{deptId}" })
    Department selectOneById(@Param("deptId") Integer deptId);
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where dept_leader=#{deptLeader}" })
    Department selectOneByLeader(@Param("deptLeader") String deptLeader);
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where dept_name=#{deptName}" })
    Department selectOneByName(@Param("deptName") String deptName);
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Department> selectDeptList();

    /*@Select({"select * from",TABLE_NAME ,"limit=#{limit} offset=#{offset}"})*/
    @Select({"select * from ",TABLE_NAME," limit #{limit} offset #{offset} "})
    List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset,
                                                 @Param("limit") Integer limit);

    @Select({"SELECT COUNT(dept_id) FROM", TABLE_NAME,
            "WHERE deptLeader = #{deptLeader} OR deptName = #{deptName}"})
    int checkDeptsExistsByNameAndleader(@Param("deptLeader") String deptLeader,
                                        @Param("deptName") String deptName);

    @Select({"select count(*) from", TABLE_NAME})
    int countDepts();


}
