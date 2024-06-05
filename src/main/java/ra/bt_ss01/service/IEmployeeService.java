package ra.bt_ss01.service;

import org.springframework.web.multipart.MultipartFile;
import ra.bt_ss01.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Integer id);
    Employee addEmployee(Employee employee, MultipartFile file);
    Employee updateEmployee(Employee employee,Integer id,MultipartFile file);
    void deleteEmployee(Integer id);
}
