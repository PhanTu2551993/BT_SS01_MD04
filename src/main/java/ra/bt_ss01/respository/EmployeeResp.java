package ra.bt_ss01.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.bt_ss01.model.entity.Employee;

public interface EmployeeResp extends JpaRepository<Employee,Integer> {
}
