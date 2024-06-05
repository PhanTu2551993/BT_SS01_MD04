package ra.bt_ss01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.bt_ss01.model.entity.Employee;
import ra.bt_ss01.service.IDepartmentService;
import ra.bt_ss01.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "views/Employee/addEmployee";
    }
    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("employee") Employee employee,@RequestParam("departmentId") Integer departmentId,@RequestParam("file") MultipartFile file) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.addEmployee(employee,file);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "views/Employee/editEmployee";
    }
    @PostMapping("/edit/{id}")
    public String handleEdit(@PathVariable("id") Integer id,@ModelAttribute("employee") Employee employee,@RequestParam("departmentId") Integer departmentId,@RequestParam("file") MultipartFile file) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.updateEmployee(employee,id,file);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}