package lk.zerocode.vehicle_management_system.controllers.requests;

import lombok.Data;

@Data
public class VehicleRequest {
    private String color;
    private String capacity;
    private Long modelId;
}
