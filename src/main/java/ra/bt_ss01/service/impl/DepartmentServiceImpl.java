package ra.bt_ss01.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.bt_ss01.model.entity.Department;
import ra.bt_ss01.respository.DepartmentResp;
import ra.bt_ss01.service.IDepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    private final DepartmentResp departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department,Integer id) {
        department.setId(id);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            if(!department.getEmployees().isEmpty()) {
                department.setStatus(false);
                updateDepartment(department,department.getId());
            } else {
                departmentRepository.delete(getDepartmentById(id));

            }
        }
    }
}
