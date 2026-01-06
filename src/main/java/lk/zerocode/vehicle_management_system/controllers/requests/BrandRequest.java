package lk.zerocode.vehicle_management_system.controllers.requests;

import lombok.Data;

@Data
public class BrandRequest {
    private String brandId;
    private String name;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
