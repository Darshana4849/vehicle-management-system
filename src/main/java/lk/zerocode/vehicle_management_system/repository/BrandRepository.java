package lk.zerocode.vehicle_management_system.repository;

import lk.zerocode.vehicle_management_system.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
