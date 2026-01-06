package lk.zerocode.vehicle_management_system.repository;

import lk.zerocode.vehicle_management_system.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
