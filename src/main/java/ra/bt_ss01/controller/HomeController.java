package ra.bt_ss01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.bt_ss01.model.entity.Department;
import ra.bt_ss01.model.entity.Employee;
import ra.bt_ss01.service.IDepartmentService;
import ra.bt_ss01.service.IEmployeeService;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final IDepartmentService departmentService;
    private final IEmployeeService employeeService;
    @RequestMapping
    public String index(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "views/index";
    }
}