package ra.bt_ss01.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.bt_ss01.model.entity.Department;

public interface DepartmentResp extends JpaRepository<Department,Integer> {
}
