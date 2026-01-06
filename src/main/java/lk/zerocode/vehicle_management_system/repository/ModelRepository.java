package lk.zerocode.vehicle_management_system.repository;

import lk.zerocode.vehicle_management_system.models.Brand;
import lk.zerocode.vehicle_management_system.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
