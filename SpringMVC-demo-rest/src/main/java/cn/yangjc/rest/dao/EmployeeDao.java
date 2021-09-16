package cn.yangjc.rest.dao;

import cn.yangjc.rest.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeeMap = null;

    private static Integer eno = 105;

    static {
        employeeMap = new ConcurrentHashMap<>();
        employeeMap.put(101,new Employee(101,"员工A","P6",1));
        employeeMap.put(102,new Employee(102,"员工B","M6",0));
        employeeMap.put(103,new Employee(103,"员工C","P7",1));
        employeeMap.put(104,new Employee(104,"员工D","P10",1));

    }

    /**
     * 查询所有员工
     */
    public Collection<Employee> listAllEmployee() {
        return employeeMap.values();
    }

    /**
     * 根据工号查询相应员工
     */
    public Employee getEmployeeById(Integer id) {
        return employeeMap.get(id);
    }

    /**
     * 保存员工信息
     */
    public Boolean saveEmployee(Employee employee) {
        if (Objects.isNull(employee.getEid()))
            employee.setEid(eno++);
        employeeMap.put(employee.getEid(),employee);
        return true;
    }

    /**
     * 删除员工
     */
    public Boolean deleteEmployeeById(Integer id) {
        employeeMap.remove(id);
        return true;
    }



}
