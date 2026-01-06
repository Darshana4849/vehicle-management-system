package lk.zerocode.vehicle_management_system.controllers.requests;

import lombok.Data;

@Data
public class BrandRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
