package com.xjl.controller;

import com.xjl.bean.Department;
import com.xjl.service.DepartmentService;
import com.xjl.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping(value = "/xjl/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 删除
     * @param deptId
     * @return
     */
    @RequestMapping(value = "/delDept/{deptId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonInfo deleteDept(@PathVariable("deptId") Integer deptId){
        int res = 0;
        if (deptId > 0){
            res = departmentService.deleteDeptById(deptId);
        }
        if (res != 1){
            return JsonInfo.fail().addInfo("del_dept_error", "删除异常");
        }
        return JsonInfo.success();
    }

    /**
     * 部门更改
     * @param deptId
     * @param department
     * @return
     */
    @RequestMapping(value = "/updateDept/{deptId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonInfo updateDeptById(@PathVariable("deptId") Integer deptId, Department department){

        int res = 0;
        if (deptId > 0){
            res = departmentService.updateDeptById(deptId, department);
        }
        if (res != 1){
            return JsonInfo.fail().addInfo("update_dept_error", "部门更新失败");
        }
        return JsonInfo.success();
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @RequestMapping(value = "/addDept", method = RequestMethod.PUT)
    @ResponseBody
    public JsonInfo addDept(Department department){
        int res = departmentService.addDept(department);
        if (res != 1){
            return JsonInfo.fail().addInfo("add_dept_error", "添加异常！");
        }
        return JsonInfo.success();
    }

    /**
     * 查询部门信息总页码数
     * @return
     */
    @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
    @ResponseBody
    public JsonInfo getTotalPages(){

        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = departmentService.getDeptCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;

        return JsonInfo.success().addInfo("totalPages", totalPages);
    }

    /**
     *
     */

    @RequestMapping(value = "/getDeptById/{deptId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonInfo getDeptById(@PathVariable("deptId") Integer deptId){
        Department department = null;
        if (deptId > 0){
            department = departmentService.getDeptById(deptId);
        }
        if (department != null){
            return JsonInfo.success().addInfo("department", department);
        }
        return JsonInfo.fail().addInfo("get_dept_error", "无部门信息");
    }

    /**
     * 分页查询：返回指定页数对应的数据
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/getDeptList", method = RequestMethod.GET)
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("departmentPage");
        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = departmentService.getDeptCount();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;
        //每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
        int offset = (pageNo - 1)*limit;
        List<Department> departments = departmentService.getDeptList(offset, limit);

        mv.addObject("departments", departments)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }

    /**
     * 查询所有部门名称
     * @return
     */
    @RequestMapping(value = "/getDeptName", method = RequestMethod.GET)
    @ResponseBody
    public JsonInfo getDeptName(){
        List<Department> departmentList = departmentService.getDeptName();
        if (departmentList != null){
            return JsonInfo.success().addInfo("departmentList", departmentList);
        }
        return JsonInfo.fail();
    }


}
