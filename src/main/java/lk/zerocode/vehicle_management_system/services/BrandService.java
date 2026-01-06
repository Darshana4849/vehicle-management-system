package lk.zerocode.vehicle_management_system.services;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.models.Brand;

public interface BrandService {

    void create (BrandRequest brandRequest);

    Brand findById(Long id);

}
