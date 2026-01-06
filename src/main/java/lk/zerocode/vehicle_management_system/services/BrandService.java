package lk.zerocode.vehicle_management_system.services;

import lk.zerocode.vehicle_management_system.controllers.requests.BrandRequest;
import lk.zerocode.vehicle_management_system.controllers.response.BrandResponse;
import lk.zerocode.vehicle_management_system.models.Brand;
import java.util.List;

public interface BrandService {

    void create (BrandRequest brandRequest);

    Brand findById(Long id);

}
