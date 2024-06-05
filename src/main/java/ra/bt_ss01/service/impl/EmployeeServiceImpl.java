package ra.bt_ss01.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.bt_ss01.model.entity.Employee;
import ra.bt_ss01.respository.EmployeeResp;
import ra.bt_ss01.service.IEmployeeService;
import ra.bt_ss01.service.Uploadfile;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeResp employeeRepository;
    private final Uploadfile uploadFile;
    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee, MultipartFile file) {
        if (file!=null && file.getSize()>0) {
            employee.setAvatar(uploadFile.uploadToLocal(file));
        }else {
            employee.setAvatar("https://media.istockphoto.com/id/1196083861/vi/vec-to/b%E1%BB%99-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-%C4%91%E1%BA%A7u-ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-%C4%91%C6%A1n-gi%E1%BA%A3n.jpg?s=612x612&w=0&k=20&c=7juGotIovn0c2KFGhZ_DcEqpfiSyYl-zz2ty9XYnYNs=");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id,MultipartFile file) {
        employee.setEmpId(id);
        if (file!=null && file.getSize()>0) {
            employee.setAvatar(uploadFile.uploadToLocal(file));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}