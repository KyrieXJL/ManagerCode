package com.xjl.test;

import com.xjl.bean.Department;
import com.xjl.bean.Employee;
import com.xjl.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author xjl
 * @date 2020/6/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    //用来批量插入操作
    @Autowired
    SqlSession sqlSession;

    /**
     * 单条记录插入
     */
    @Test
    public void insertOneTest() {
        Employee employee = new Employee(null, "aa", "aa@qq.com", "男", 2);
        int res = employeeMapper.insertOne(employee);
        System.out.println(res);
    }

    /**
     * 批量插入
     */
    @Test
    public void insertEmpsBatchTest() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 1; i < 200; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            employeeMapper.insertOne(new Employee(i, "name_" + uid, uid + "@qq.com", i % 2 == 0 ? "女" : "男", i % 6 + 1));

        }
    }

    @Test
    public void updateOneByIdTest() {
        Employee employee =
                new Employee(1, "aa", "aa@qq.com", "女", 3);
        int res = employeeMapper.updateOneById(202, employee);
        System.out.println(res);
    }

    @Test
    public void selectOneByIdTest() {
        Employee employee = employeeMapper.selectOneById(1);
        System.out.println(employee);
    }

    @Test
    public void selectOneByNameTest() {
        Employee employee = employeeMapper.selectOneByName("name_65083");
        System.out.println(employee);
    }

    @Test
    public void selectWithDeptByIdTest() {
        Department department = employeeMapper.selectWithDeptById(1);
        System.out.println(department);
    }

    @Test
    public void countEmpsTest() {
        int countEmps = employeeMapper.countEmps();
        System.out.println(countEmps);
    }

    @Test
    public void selectByLimitAndOffsetTest() {
        List<Employee> list = employeeMapper.selectByLimitAndOffset(5, 10);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void deleteOneByIdTest() {
        int res = employeeMapper.deleteOneById(202);
        System.out.println(res);

    }

}
