package cn.yangjc.rest.controller;

import cn.yangjc.rest.dao.EmployeeDao;
import cn.yangjc.rest.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/listAllEmployee")
    public String listAllEmployee(Model model) {
        Collection<Employee> employees = employeeDao.listAllEmployee();
        model.addAttribute("employees",employees);
        return "employee_list";
    }

    /**
     * 新增员工
     */
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String insertEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return "redirect:/listAllEmployee";
    }

    /**
     * 修改员工
     */
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return "redirect:/listAllEmployee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:/listAllEmployee";
    }

    /**
     * 回显员工信息并跳转页面
     */
    @GetMapping("/goEmployeeUpdate/{id}")
    public ModelAndView goEmployeeUpdate(@PathVariable("id") Integer id) {
        Employee employee = employeeDao.getEmployeeById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("emp",employee);
        mav.setViewName("employee_update");
        return mav;
    }

}
