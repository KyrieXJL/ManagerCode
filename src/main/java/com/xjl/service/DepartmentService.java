package com.xjl.service;

import com.xjl.bean.Department;
import com.xjl.mapper.DepartmentMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:xjl
 * @date:2020/5/24 21:43
 */
@Service
public class DepartmentService {
    @Autowired
   DepartmentMapper departmentMapper;
   /**
    * 根据id删除
    *
    * */
    public  int deleteDeptById(Integer id){
        return   departmentMapper.deleteDeptById(id);
    }

    /**
     * 更新用户
     * */
    public  int updateDeptById(Integer deptId,Department department){
       return departmentMapper.updateDeptById(deptId,department);
    }

    /**
     * 添加用户
     * */
    public  int addDept(Department department){
     return    departmentMapper.insertDept(department);
    }
    /**
     * 获取数据个数
     * */
    public  int getDeptCount(){
        return  departmentMapper.countDepts();
    }

    /**
     * 查询 所有用户
     * */
public List<Department> getDeptList(Integer offset,Integer limit){
    return  departmentMapper.selectDeptsByLimitAndOffset(offset,limit);
}

    /**
     * 通过id查询用户
     * */

    public  Department  getDeptById(Integer deptId){

        return  departmentMapper.selectOneById(deptId);
    }

    /**
     * 通过name查询单个用户
     **/

    public  Department getDeptByName(String deptName){
        return departmentMapper.selectOneByName(deptName);
    }

    /***
     * 通过name查询所有用户
     */

    public  List<Department> getDeptName(){
        return departmentMapper.selectDeptList();
    }
}
